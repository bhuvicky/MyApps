package com.bhuvanesh.myapps;

import android.animation.ObjectAnimator;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class CompassActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor compass;

    private ImageView ivCompass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        ivCompass = (ImageView) findViewById(R.id.ivCompass);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        compass = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, compass, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivCompass, "rotation", event.values[0]);
        animator.setDuration(10);
        animator.start();

        ivCompass.invalidate();
        Log.i("vicky", event.values[0] + " " + event.values[1] + " " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
