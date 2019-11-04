package com.example.podometro_y_brujula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView tv_Counted_Steps, tvHeading;
    SensorManager sensorManager;
    boolean running = false;
    private ImageView imageview_compass;
    private float currentDegree = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        tv_Counted_Steps = findViewById (R.id.tv_Counted_Steps);
        imageview_compass = findViewById(R.id.imageViewCompass);
        tvHeading = findViewById(R.id.tvHeading);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor countSensor = Objects.requireNonNull(sensorManager).getDefaultSensor (Sensor.TYPE_STEP_COUNTER);
        if(countSensor!= null){
            sensorManager.registerListener( this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText ( this,"Sensor no encontrado",Toast.LENGTH_SHORT ).show ();
        }
    }

    @Override
    protected void onResume() {
        super.onResume ();
        running = true;

        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause ();
        running = false;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            if (running){
                tv_Counted_Steps.setText ( String.valueOf ( event.values[0] ) );
            }
        }else if (sensor.getType() == Sensor.TYPE_ORIENTATION) {
            float degrees = Math.round(event.values[0]);
            tvHeading.setText(degrees + "°");
            RotateAnimation ra = new RotateAnimation(
                    currentDegree,
                    -degrees,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            ra.setFillAfter(true);
            ra.setDuration(210);
            imageview_compass.startAnimation(ra);
            currentDegree = -degrees;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
