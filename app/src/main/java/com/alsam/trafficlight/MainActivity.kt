package com.alsam.trafficlight

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var trafficButton: Button
    private lateinit var redLight: ImageView
    private lateinit var yellowLight: ImageView
    private lateinit var greenLight: ImageView

    private var currentState = 0 // 0: Red, 1: Green, 2: Yellow

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trafficButton = findViewById(R.id.trafficButton)
        redLight = findViewById(R.id.red_light)
        yellowLight = findViewById(R.id.yellow_light)
        greenLight = findViewById(R.id.green_light)

        // Set the initial background color of the button to red
        trafficButton.setBackgroundColor(resources.getColor(R.color.red))

        trafficButton.setOnClickListener {
            when (currentState) {
                0 -> {
                    // Change to Green
                    trafficButton.text = "GO"
                    trafficButton.setBackgroundColor(resources.getColor(R.color.green))
                    redLight.visibility = View.INVISIBLE
                    yellowLight.visibility = View.INVISIBLE
                    greenLight.visibility = View.VISIBLE
                    currentState = 1
                }
                1 -> {
                    // Change to Yellow
                    trafficButton.text = "WAIT"
                    trafficButton.setBackgroundColor(resources.getColor(R.color.yellow))
                    redLight.visibility = View.INVISIBLE
                    yellowLight.visibility = View.VISIBLE
                    greenLight.visibility = View.INVISIBLE
                    currentState = 2
                }
                else -> {
                    // Change to Red
                    trafficButton.text = "STOP"
                    trafficButton.setBackgroundColor(resources.getColor(R.color.red))
                    redLight.visibility = View.VISIBLE
                    yellowLight.visibility = View.INVISIBLE
                    greenLight.visibility = View.INVISIBLE
                    currentState = 0
                }
            }
        }
    }
}
