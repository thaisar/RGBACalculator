package com.example.rgbacalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    private lateinit var EditText1: EditText
    private lateinit var EditText2: EditText
    private lateinit var EditText3: EditText
    private lateinit var EditText4: EditText
    private lateinit var SeekBar1: SeekBar
    private lateinit var SeekBar2: SeekBar
    private lateinit var SeekBar3: SeekBar
    private lateinit var SeekBar4: SeekBar
    private lateinit var ImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
