package com.example.rgbacalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {



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


        editText1.setOnEditorActionListener { view, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_NEXT){
                if(radioButton1.isChecked){

                    val red = editText1.text.toString().toInt()
                    val green  = editText2.text.toString().toInt()
                    val blue = editText3.text.toString().toInt()
                    imageView.setColorFilter(Color.rgb(red, green, blue))
                }
                if(radioButton2.isChecked){
                    val red = editText1.text.toString()
                    val green = editText2.text.toString()
                    val blue = editText3.text.toString()
                    val alpha = editText4.text.toString()
                    imageView.setColorFilter(Color.parseColor("#$alpha$red$green$blue"))
                }

            }

            false
        }
        editText2 = findViewById(R.id.main_editText_2)
        editText2.setOnEditorActionListener { view, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_DONE){

                if(radioButton1.isChecked){
                    val red = editText1.text.toString().toInt()
                    val green = editText2.text.toString().toInt()
                    val blue = editText3.text.toString().toInt()
                    imageView.setColorFilter(Color.rgb(red, green, blue))
                }
                if(radioButton2.isChecked){
                    val red = editText1.text.toString()
                    val green = editText2.text.toString()
                    val blue = editText3.text.toString()
                    val alpha = editText4.text.toString()
                    imageView.setColorFilter(Color.parseColor("#$alpha$red$green$blue"))
                }

            }

            false
        }
        editText3 = findViewById(R.id.main_editText_3)
        editText3.setOnEditorActionListener { view, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_DONE){

                if(radioButton1.isChecked){
                    val red = editText1.text.toString().toInt()
                    val green = editText2.text.toString().toInt()
                    val blue = editText3.text.toString().toInt()
                    imageView.setColorFilter(Color.rgb(red, green, blue))
                }
                if(radioButton2.isChecked){
                    val red = editText1.text.toString()
                    val green = editText2.text.toString()
                    val blue = editText3.text.toString()
                    val alpha = editText4.text.toString()
                    imageView.setColorFilter(Color.parseColor("#$alpha$red$green$blue"))
                }

            }

            false
        }
        editText4 = findViewById(R.id.main_editText_4)
        editText4.setOnEditorActionListener { view, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_DONE){

                if(radioButton1.isChecked){
                    if(editText4.text.toString().toInt() in 0 .. 255){
                        val red = editText1.text.toString().toInt()
                        val green = editText2.text.toString().toInt()
                        val blue = editText3.text.toString().toInt()
                        imageView.setColorFilter(Color.rgb(red, green, blue))

                        val alpha = editText4.text.toString().toFloat()/255F
                        imageView.alpha = alpha
                    }else{

                    }

                }
                if(radioButton2.isChecked){
                    val red = editText1.text.toString()
                    val green = editText2.text.toString()
                    val blue = editText3.text.toString()
                    val alpha = editText4.text.toString()
                    imageView.setColorFilter(Color.parseColor("#$alpha$red$green$blue"))
                }

            }

            false
        }
        seekBar1  = findViewById(R.id.main_seekBar_1)
        seekBar1.setOnSeekBarChangeListener(this)
        seekBar2  = findViewById(R.id.main_seekBar_2)
        seekBar2.setOnSeekBarChangeListener(this)
        seekBar3  = findViewById(R.id.main_seekBar_3)
        seekBar3.setOnSeekBarChangeListener(this)
        seekBar4  = findViewById(R.id.main_seekBar_4)
        seekBar4.setOnSeekBarChangeListener(this)
        imageView  = findViewById(R.id.main_imageView)


        radioButton1 = findViewById(R.id.main_radioButton_1)
        radioButton2 = findViewById(R.id.main_radioButton_2)

        main_radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if(radioButton1.isChecked){

            }
            if(radioButton2.isChecked){
                editText1.setText("FF")
                editText2.setText("FF")
                editText3.setText("FF")
                editText4.setText("FF")
                val red = editText1.text.toString()
                val green = editText2.text.toString()
                val blue = editText3.text.toString()
                val alpha = editText4.text.toString()
                imageView.alpha = 1F
                imageView.setColorFilter(Color.parseColor("#00000000"))
            }



        }

    }


    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        if(seekBar!!.id == seekBar1.id){

            val red = seekBar1.progress
            val green = seekBar2.progress
            val blue = seekBar3.progress
            imageView.setColorFilter(Color.rgb(red, green, blue))

            if(radioButton1.isChecked){
                editText1.setText("$progress")
            }
        }

        if(seekBar!!.id == seekBar2.id){

            val red = seekBar1.progress
            val green = seekBar2.progress
            val blue = seekBar3.progress
            imageView.setColorFilter(Color.rgb(red, green, blue))

            if(radioButton1.isChecked){
                editText2.setText("$progress")
            }
        }

        if(seekBar!!.id == seekBar3.id){

            val red = seekBar1.progress
            val green = seekBar2.progress
            val blue = seekBar3.progress
            imageView.setColorFilter(Color.rgb(red, green, blue))

            if(radioButton1.isChecked){
                editText3.setText("$progress")
            }
        }


        if(seekBar!!.id == seekBar4.id){

            val red = seekBar1.progress
            val green = seekBar2.progress
            val blue = seekBar3.progress
            imageView.setColorFilter(Color.rgb(red, green, blue))

            val alpha = seekBar4.progress.toFloat()/255F
            imageView.alpha = alpha

            if(radioButton1.isChecked){
                editText4.setText("$progress")
            }
        }

    }
    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}
