package com.example.rgbacalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var seekBar1: SeekBar
    private lateinit var seekBar2: SeekBar
    private lateinit var seekBar3: SeekBar
    private lateinit var seekBar4: SeekBar
    private lateinit var imageView: ImageView
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.main_editText_1)
        editText2 = findViewById(R.id.main_editText_2)
        editText3 = findViewById(R.id.main_editText_3)
        editText4 = findViewById(R.id.main_editText_4)
        seekBar1  = findViewById(R.id.main_seekBar_1)
        seekBar2  = findViewById(R.id.main_seekBar_2)
        seekBar3  = findViewById(R.id.main_seekBar_3)
        seekBar4  = findViewById(R.id.main_seekBar_4)
        imageView  = findViewById(R.id.main_imageView)

        radioButton1 = findViewById(R.id.main_radioButton_1)
        radioButton2 = findViewById(R.id.main_radioButton_2)
    }
}
