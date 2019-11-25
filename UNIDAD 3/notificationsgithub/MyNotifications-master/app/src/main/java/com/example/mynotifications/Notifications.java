package com.example.mynotifications;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
/**
 * @author Daniel Rosillo
 * github@DanielRosillo
 * danielrosillo.github.io
 */
public class Notifications extends ContextWrapper
{

    private NotificationManager mManager;//Manejador del sistema.
    public static final String ANDROID_CHANNEL_ID = "com.example.mynotifications";//ID de la aplicación.
    public static final String ANDROID_CHANNEL_NAME = "General Notifications";//Nombre del canal, puede ser un arreglo de nombres.
    private Context context;

    public Notifications(Context base)
    {
        super (base);
        context = base;
        createChannels ();
    }

    public void createChannels()
    {
        NotificationChannel androidChannel = new NotificationChannel (ANDROID_CHANNEL_ID, ANDROID_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);//Prioridad.
        androidChannel.enableLights (true);//Efectos de luz.
        androidChannel.enableVibration (true);//Vibración.
        androidChannel.setLightColor (Color.WHITE);//Color de la luz.
        androidChannel.setLockscreenVisibility (Notification.VISIBILITY_PRIVATE);//Configuración de privacidad.
        getManager ().createNotificationChannel (androidChannel);
    }


    public void push(PendingIntent pendingIntent, String title, String content)
    {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder (context,
                ANDROID_CHANNEL_ID);
        notificationBuilder
                .setAutoCancel (true)//Eliminar de la lista al tocarla en la barra de notificaciones.
                .setDefaults (Notification.DEFAULT_ALL)
                .setWhen (System.currentTimeMillis ())//Muestra el tiempo desde que se mando la notificación.
                .setContentIntent (pendingIntent)//Acción que se hara.
                .setSmallIcon (R.drawable.notification)
                .setColor (ContextCompat.getColor (this, R.color.colorAccent))
                .setTicker ("RosilloLabs♥")
                .setContentTitle (title)//Titulo en la barra.
                .setContentText (content);//Contenido de la notificación.
        getManager ().notify (1, notificationBuilder.build ());
    }

    public NotificationManager getManager()
    {
        if (mManager == null)
            mManager = (NotificationManager) getSystemService (Context.NOTIFICATION_SERVICE);

        return mManager;
    }
}
