package com.example.m2_hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customView = findViewById<CustomView>(R.id.customView)

        customView.setTopText("Верхняя строка")
        customView.setBottomText("Нижняя строка")
    }
}