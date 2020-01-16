package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AcceleromerterActivity extends AppCompatActivity {

    private TextView tvShowAxis;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleromerter);
        setTitle("Accelerometer Sensor");

        tvShowAxis=findViewById(R.id.tvShowAxis);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor sensor =sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sel =new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                String xAxis = "x: " + values[0];
                String yAxis = "x: " + values[1];
                String zAxis = "x: " + values[2];
                tvShowAxis.setText(xAxis + "" + yAxis + "" + zAxis);

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if (sensor !=null) {
            sensorManager.registerListener(sel, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show();
        }
    }
}
