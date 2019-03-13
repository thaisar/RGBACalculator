package com.example.rgbacalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
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
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (radioButton1.isChecked) {
                    if (editText1.text.toString().toInt() in 0..255) {
                        attEditTextDecimal(seekBar1)
                    } else {
                        editText1.setText(0)
                        Toast.makeText(applicationContext, "Número inválido", LENGTH_SHORT).show()
                    }
                } else if (radioButton2.isChecked) {
                if (editText1.text.toString() in Integer.parseInt("0", 16).toString() .. Integer.parseInt("ff", 16).toString()) {
                        attEditTextHexadecimal(seekBar1)
                    } else {
                        editText1.setText("ff")
                        Toast.makeText(applicationContext, "Número inválido", LENGTH_SHORT).show()
                    }

                }
            }

            false
        }
        editText2 = findViewById(R.id.main_editText_2)
        editText2.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {

                if (radioButton1.isChecked) {
                    if (editText2.text.toString().toInt() in 0..255) {
                        attEditTextDecimal(seekBar2)
                    } else {
                        editText2.setText(0)
                        Toast.makeText(applicationContext, "Número inválido", LENGTH_SHORT).show()
                    }
                } else if (radioButton2.isChecked) {
                    attEditTextHexadecimal(seekBar2)
                }

            }

            false
        }
        editText3 = findViewById(R.id.main_editText_3)
        editText3.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {

                if (radioButton1.isChecked) {
                    if (editText3.text.toString().toInt() in 0..255) {
                        attEditTextDecimal(seekBar3)
                    } else {
                        editText3.setText(0)
                        Toast.makeText(applicationContext, "Número inválido", LENGTH_SHORT).show()
                    }
                } else if (radioButton2.isChecked) {
                    attEditTextHexadecimal(seekBar3)
                }

            }

            false
        }
        editText4 = findViewById(R.id.main_editText_4)
        editText4.setOnEditorActionListener { view, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {

                if (radioButton1.isChecked) {
                    if (editText4.text.toString().toInt() in 0..255) {
                        attEditTextDecimal(seekBar4)
                    } else {
                        editText4.setText(0)
                        Toast.makeText(applicationContext, "Número inválido", LENGTH_SHORT).show()
                    }

                } else if (radioButton2.isChecked) {
                    attEditTextHexadecimal(seekBar4)
                }

            }

            false
        }
        seekBar1 = findViewById(R.id.main_seekBar_1)
        seekBar1.setOnSeekBarChangeListener(this)
        seekBar2 = findViewById(R.id.main_seekBar_2)
        seekBar2.setOnSeekBarChangeListener(this)
        seekBar3 = findViewById(R.id.main_seekBar_3)
        seekBar3.setOnSeekBarChangeListener(this)
        seekBar4 = findViewById(R.id.main_seekBar_4)
        seekBar4.setOnSeekBarChangeListener(this)

        imageView = findViewById(R.id.main_imageView)

        radioButton1 = findViewById(R.id.main_radioButton_1)
        radioButton2 = findViewById(R.id.main_radioButton_2)

        main_radioGroup.setOnCheckedChangeListener { group, checkedId ->

            if (radioButton1.isChecked) {

                val red = when (editText1.text.toString().length == 1) {
                    true -> "0" + editText1.text.toString()
                    false -> editText1.text.toString()
                }
                val green = when (editText2.text.toString().length == 1) {
                    true -> "0" + editText2.text.toString()
                    false -> editText2.text.toString()
                }
                val blue = when (editText3.text.toString().length == 1) {
                    true -> "0" + editText3.text.toString()
                    false -> editText3.text.toString()
                }
                val alpha = when (editText4.text.toString().length == 1) {
                    true -> "0" + editText4.text.toString()
                    false -> editText4.text.toString()
                }
                editText1.setText(Integer.parseInt(red, 16).toString())
                editText2.setText(Integer.parseInt(green, 16).toString())
                editText3.setText(Integer.parseInt(blue, 16).toString())
                editText4.setText(Integer.parseInt(alpha, 16).toString())

                editText1.hint = "255"
                editText2.hint = "255"
                editText3.hint = "255"
                editText4.hint = "255"

            }
            if (radioButton2.isChecked) {
                editText1.setText(Integer.toHexString(editText1.text.toString().toInt()))
                editText2.setText(Integer.toHexString(editText2.text.toString().toInt()))
                editText3.setText(Integer.toHexString(editText3.text.toString().toInt()))
                editText4.setText(Integer.toHexString(editText4.text.toString().toInt()))

                editText1.hint = "ff"
                editText2.hint = "ff"
                editText3.hint = "ff"
                editText4.hint = "ff"
            }

        }

    }

    private fun attEditTextDecimal(seekBar: SeekBar?) {

        val red = editText1.text.toString().toInt()
        val green = editText2.text.toString().toInt()
        val blue = editText3.text.toString().toInt()
        val alpha = editText4.text.toString().toInt()

        imageView.setColorFilter(Color.rgb(red, green, blue))
        imageView.alpha = alpha.toFloat() / 255F
        when {
            seekBar!!.id == seekBar1.id -> seekBar1.progress = red
            seekBar.id == seekBar2.id -> seekBar2.progress = green
            seekBar.id == seekBar3.id -> seekBar3.progress = blue
            seekBar.id == seekBar4.id -> seekBar4.progress = alpha
        }

    }


    private fun attEditTextHexadecimal(seekBar: SeekBar?) {
        val red = when (editText1.text.toString().length == 1) {
            true -> "0" + editText1.text.toString()
            false -> editText1.text.toString()
        }
        val green = when (editText2.text.toString().length == 1) {
            true -> "0" + editText2.text.toString()
            false -> editText2.text.toString()
        }
        val blue = when (editText3.text.toString().length == 1) {
            true -> "0" + editText3.text.toString()
            false -> editText3.text.toString()
        }
        val alpha = when (editText4.text.toString().length == 1) {
            true -> "0" + editText4.text.toString()
            false -> editText4.text.toString()
        }

        imageView.setColorFilter(Color.parseColor("#$alpha$red$green$blue"))
        val test = Integer.parseInt(red, 16)
        Toast.makeText(this, "$test", Toast.LENGTH_SHORT).show()

        when {
            seekBar!!.id == seekBar1.id -> seekBar1.progress = Integer.parseInt(red, 16)
            seekBar.id == seekBar2.id -> seekBar2.progress = Integer.parseInt(green, 16)
            seekBar.id == seekBar3.id -> seekBar3.progress = Integer.parseInt(blue, 16)
            seekBar.id == seekBar4.id -> seekBar4.progress = Integer.parseInt(alpha, 16)
        }
    }


    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        val red = seekBar1.progress
        val green = seekBar2.progress
        val blue = seekBar3.progress
        val alpha = seekBar4.progress

        imageView.setColorFilter(Color.rgb(red, green, blue))
        imageView.alpha = alpha.toFloat() / 255F

        if (radioButton1.isChecked) when {
            seekBar!!.id == seekBar1.id -> editText1.setText("$red")
            seekBar.id == seekBar2.id -> editText2.setText("$green")
            seekBar.id == seekBar3.id -> editText3.setText("$blue")
            seekBar.id == seekBar4.id -> editText4.setText(alpha.toString())
        } else if (radioButton2.isChecked) when {
            seekBar!!.id == seekBar1.id -> editText1.setText(Integer.toHexString(red))
            seekBar.id == seekBar2.id -> editText2.setText(Integer.toHexString(green))
            seekBar.id == seekBar3.id -> editText3.setText(Integer.toHexString(blue))
            seekBar.id == seekBar4.id -> editText4.setText(Integer.toHexString(alpha))
        }

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }


}
