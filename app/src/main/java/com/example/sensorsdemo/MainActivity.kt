package com.example.sensorsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camera_button.setOnClickListener {
            startCameraActivity()
        }
        sensors_button.setOnClickListener {
            startSensorsActivity()
        }
    }

    private fun startCameraActivity() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    private fun startSensorsActivity() {
        val intent = Intent(this, SensorsActivity::class.java)
        startActivity(intent)
    }
}