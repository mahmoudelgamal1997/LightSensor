package com.example2017.android.lightsensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mSensor= mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        txt=(TextView)findViewById(R.id.txt);




    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        txt.setText(String.valueOf( sensorEvent.values[0]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_NORMAL);

        
    }
}
