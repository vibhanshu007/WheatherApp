package com.example.wheatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wheatherapp.R

class MainActivity : AppCompatActivity() {

    private val tag: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
