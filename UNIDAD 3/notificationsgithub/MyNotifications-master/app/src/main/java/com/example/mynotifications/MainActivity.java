package com.example.mynotifications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
/**
 * @author Daniel Rosillo
 * github@DanielRosillo
 * danielrosillo.github.io
 */
public class MainActivity extends AppCompatActivity
{
    private Button button;
    private Notifications handle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        button = findViewById (R.id.button);
        handle = new Notifications (this);
        events();
    }

    private void events()
    {
        button.setOnClickListener (event->
        {

            Intent notificationIntent;
            notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.bookmanager.danielrosillo.bookmanager&hl=es_419"));
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
            handle.push (contentIntent, "Don't save your password anymore!", "Get Started");
        });
    }
}
