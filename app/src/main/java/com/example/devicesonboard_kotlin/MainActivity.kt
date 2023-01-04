package com.example.devicesonboard_kotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
//import com.example.devicesonboard_kotlin.databinding.ActivityMainBinding

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
//import android.os.Bundle
import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Information about Sensors present in the
    // device is supplied by Sensor Manager of the device
    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the variable sensorManager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // getSensorList(Sensor.TYPE_ALL) lists all the sensors present in the device
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        // Text View that shall display this list
        val textView = findViewById<TextView>(R.id.tv)

        // Converting List to String and displaying
        // every sensor and its information on a new line
        for (sensors in deviceSensors) {
            textView.append(sensors.toString() + "\n\n")
        }
    }
}
