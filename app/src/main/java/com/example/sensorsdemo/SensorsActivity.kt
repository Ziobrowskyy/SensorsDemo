package com.example.sensorsdemo

import android.hardware.SensorManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sensors.*

class SensorsActivity : AppCompatActivity(), SensorEventListener {
    companion object {
    }

    private lateinit var sensorManager: SensorManager
    private var mAccelerometer: Sensor? = null
    private var mLight : Sensor ?= null
    private var mGyroscope : Sensor ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sensors)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        mGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                acc_x_tv.text = event.values[0].toString()
                acc_y_tv.text = event.values[1].toString()
                acc_z_tv.text = event.values[2].toString()
            }

            if (event.sensor.type == Sensor.TYPE_LIGHT) {
                light_sensor_tv.text = event.values[0].toString()
            }

            if (event.sensor.type == Sensor.TYPE_GYROSCOPE) {
                gyro_x_tv.text = event.values[0].toString()
                gyro_y_tv.text = event.values[1].toString()
                gyro_z_tv.text = event.values[2].toString()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}


