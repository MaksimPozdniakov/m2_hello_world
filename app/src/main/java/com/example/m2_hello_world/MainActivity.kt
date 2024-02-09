package com.example.m2_hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m2_hello_world.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.customView.setTopText("Верхняя строка")
        binding.customView.setBottomText("Нижняя строка")
    }
}