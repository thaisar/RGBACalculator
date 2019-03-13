package com.example.rgbacalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var mEditTextColorRed: EditText
    private lateinit var mEditTextColorGreen: EditText
    private lateinit var mEditTextColorBlue: EditText
    private lateinit var mEditTextAlpha: EditText
    private lateinit var mSeekBarColorRed: SeekBar
    private lateinit var mSeekBarColorGreen: SeekBar
    private lateinit var mSeekBarColorBlue: SeekBar
    private lateinit var mSeekBarAlpha: SeekBar
    private lateinit var mImageViewRGBA: ImageView
    private lateinit var mRadioButtonDecimal: RadioButton
    private lateinit var mRadioButtonHexadecimal: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextColorRed = findViewById(R.id.main_editText_colorRed)
        mEditTextColorRed.setOnEditorActionListener { view, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                if(mRadioButtonDecimal.isChecked){
                    if(mEditTextColorRed.text.toString().toInt() in 0 .. 255) {
                        attEditTextDecimal(mSeekBarColorRed)
                    } else {
                        mEditTextColorRed.setText("0")
                        attEditTextDecimal(mSeekBarColorRed)
                        Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                    }
                }else if(mRadioButtonHexadecimal.isChecked){
                    if(hexFilter(mEditTextColorRed.text.toString())) {
                        if(Integer.parseInt(mEditTextColorRed.text.toString(), 16) in 0 .. 255) {
                            attEditTextHexadecimal(mSeekBarColorRed)
                        } else {
                            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                            mEditTextColorRed.setText("0")
                            attEditTextHexadecimal(mSeekBarColorRed)
                        }
                    }else {
                        Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                        mEditTextColorRed.setText("0")
                        attEditTextHexadecimal(mSeekBarColorRed)
                    }

                }

            }
            false
        }
        mEditTextColorGreen = findViewById(R.id.main_editText_colorGreen)
        mEditTextColorGreen.setOnEditorActionListener { view, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_DONE){

                if(mRadioButtonDecimal.isChecked){
                    if(mEditTextColorGreen.text.toString().toInt() in 0 .. 255) {
                        attEditTextDecimal(mSeekBarColorGreen)
                    } else {
                        mEditTextColorGreen.setText("0")
                        attEditTextDecimal(mSeekBarColorGreen)
                        Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                    }
                }else if(mRadioButtonHexadecimal.isChecked){
                    if(hexFilter(mEditTextColorGreen.text.toString())) {
                        if(Integer.parseInt(mEditTextColorGreen.text.toString(), 16) in 0 .. 255) {
                            attEditTextHexadecimal(mSeekBarColorGreen)
                        } else {
                            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                            mEditTextColorGreen.setText("0")
                            attEditTextHexadecimal(mSeekBarColorGreen)
                        }
                    }else {
                        Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                        mEditTextColorGreen.setText("0")
                        attEditTextHexadecimal(mSeekBarColorGreen)
                    }

                }

            }

            false
        }
        mEditTextColorBlue = findViewById(R.id.main_editText_colorBlue)
        mEditTextColorBlue.setOnEditorActionListener { view, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_DONE){

                if(mRadioButtonDecimal.isChecked){
                    if(mEditTextColorBlue.text.toString().toInt() in 0 .. 255) {
                        attEditTextDecimal(mSeekBarColorBlue)
                    } else {
                        mEditTextColorBlue.setText("0")
                        attEditTextDecimal(mSeekBarColorBlue)
                        Toast.makeText(this, "Número incorreto", Toast.LENGTH_SHORT).show()
                    }
                }else if(mRadioButtonHexadecimal.isChecked){
                    if(hexFilter(mEditTextColorBlue.text.toString())) {
                        if(Integer.parseInt(mEditTextColorBlue.text.toString(), 16) in 0 .. 255) {
                            attEditTextHexadecimal(mSeekBarColorBlue)
                        } else {
                            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                            mEditTextColorBlue.setText("0")
                            attEditTextHexadecimal(mSeekBarColorBlue)
                        }
                    }else {
                        Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                        mEditTextColorBlue.setText("0")
                        attEditTextHexadecimal(mSeekBarColorBlue)
                    }

                }

            }

            false
        }
        mEditTextAlpha = findViewById(R.id.main_editText_alpha)
        mEditTextAlpha.setOnEditorActionListener { view, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_DONE){

                if(mRadioButtonDecimal.isChecked){
                    if(mEditTextAlpha.text.toString().toInt() in 0 .. 255) {
                        attEditTextDecimal(mSeekBarAlpha)
                    } else {
                        mEditTextAlpha.setText("0")
                        attEditTextDecimal(mSeekBarAlpha)
                        Toast.makeText(this, "Número incorreto", Toast.LENGTH_SHORT).show()
                    }
                }else if(mRadioButtonHexadecimal.isChecked){
                    if(hexFilter(mEditTextAlpha.text.toString())) {
                        if(Integer.parseInt(mEditTextAlpha.text.toString(), 16) in 0 .. 255) {
                            attEditTextHexadecimal(mSeekBarAlpha)
                        } else {
                            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                            mEditTextAlpha.setText("0")
                            attEditTextHexadecimal(mSeekBarAlpha)
                        }
                    }else {
                        Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show()
                        mEditTextAlpha.setText("0")
                        attEditTextHexadecimal(mSeekBarAlpha)
                    }

                }

            }

            false
        }
        mSeekBarColorRed  = findViewById(R.id.main_seekBar_colorRed)
        mSeekBarColorRed.setOnSeekBarChangeListener(this)
        mSeekBarColorGreen  = findViewById(R.id.main_seekBar_colorGreen)
        mSeekBarColorGreen.setOnSeekBarChangeListener(this)
        mSeekBarColorBlue  = findViewById(R.id.main_seekBar_colorBlue)
        mSeekBarColorBlue.setOnSeekBarChangeListener(this)
        mSeekBarAlpha  = findViewById(R.id.main_seekBar_alpha)
        mSeekBarAlpha.setOnSeekBarChangeListener(this)

        mImageViewRGBA  = findViewById(R.id.main_imageView)

        mRadioButtonDecimal = findViewById(R.id.main_radioButton_decimal)
        mRadioButtonHexadecimal = findViewById(R.id.main_radioButton_hexadecimal)

        main_radioGroup.setOnCheckedChangeListener { group, checkedId ->

            if(mRadioButtonDecimal.isChecked){
                val red = when (mEditTextColorRed.text.toString().length == 1) {
                    true -> "0" + mEditTextColorRed.text.toString()
                    false -> mEditTextColorRed.text.toString()
                }
                val green = when (mEditTextColorGreen.text.toString().length == 1) {
                    true -> "0" + mEditTextColorGreen.text.toString()
                    false -> mEditTextColorGreen.text.toString()
                }
                val blue = when (mEditTextColorBlue.text.toString().length == 1) {
                    true -> "0" + mEditTextColorBlue.text.toString()
                    false -> mEditTextColorBlue.text.toString()
                }
                val alpha = when (mEditTextAlpha.text.toString().length == 1) {
                    true -> "0" + mEditTextAlpha.text.toString()
                    false -> mEditTextAlpha.text.toString()
                }
                mEditTextColorRed.setText(Integer.parseInt(red, 16).toString())
                mEditTextColorGreen.setText(Integer.parseInt(green, 16).toString())
                mEditTextColorBlue.setText(Integer.parseInt(blue, 16).toString())
                mEditTextAlpha.setText(Integer.parseInt(alpha, 16).toString())

                mEditTextColorRed.hint = "255"
                mEditTextColorGreen.hint = "255"
                mEditTextColorBlue.hint = "255"
                mEditTextAlpha.hint = "255"

                mEditTextColorRed.inputType = InputType.TYPE_CLASS_NUMBER
                mEditTextColorGreen.inputType = InputType.TYPE_CLASS_NUMBER
                mEditTextColorBlue.inputType = InputType.TYPE_CLASS_NUMBER
                mEditTextAlpha.inputType = InputType.TYPE_CLASS_NUMBER
            }
            if(mRadioButtonHexadecimal.isChecked){
                mEditTextColorRed.setText(Integer.toHexString(mEditTextColorRed.text.toString().toInt()))
                mEditTextColorGreen.setText(Integer.toHexString(mEditTextColorGreen.text.toString().toInt()))
                mEditTextColorBlue.setText(Integer.toHexString(mEditTextColorBlue.text.toString().toInt()))
                mEditTextAlpha.setText(Integer.toHexString(mEditTextAlpha.text.toString().toInt()))

                mEditTextColorRed.hint = "ff"
                mEditTextColorGreen.hint = "ff"
                mEditTextColorBlue.hint = "ff"
                mEditTextAlpha.hint = "ff"

                mEditTextColorRed.inputType = InputType.TYPE_CLASS_TEXT
                mEditTextColorGreen.inputType = InputType.TYPE_CLASS_TEXT
                mEditTextColorBlue.inputType = InputType.TYPE_CLASS_TEXT
                mEditTextAlpha.inputType = InputType.TYPE_CLASS_TEXT


            }
        }
    }

    private fun attEditTextDecimal(seekBar: SeekBar?){

        val red = mEditTextColorRed.text.toString().toDouble().toInt()
        val green  = mEditTextColorGreen.text.toString().toDouble().toInt()
        val blue = mEditTextColorBlue.text.toString().toDouble().toInt()
        val alpha = mEditTextAlpha.text.toString().toDouble().toInt()

        mImageViewRGBA.setColorFilter(Color.rgb(red, green, blue))
        mImageViewRGBA.alpha = alpha.toFloat()/255F
        when {
            seekBar!!.id == mSeekBarColorRed.id -> mSeekBarColorRed.progress = red
            seekBar.id == mSeekBarColorGreen.id -> mSeekBarColorGreen.progress = green
            seekBar.id == mSeekBarColorBlue.id -> mSeekBarColorBlue.progress = blue
            seekBar.id == mSeekBarAlpha.id -> mSeekBarAlpha.progress = alpha
        }
    }


    private fun attEditTextHexadecimal(seekBar: SeekBar?){
        val red = when (mEditTextColorRed.text.toString().length == 1) {
            true -> "0" + mEditTextColorRed.text.toString()
            false -> mEditTextColorRed.text.toString()
        }
        val green = when (mEditTextColorGreen.text.toString().length == 1) {
            true -> "0" + mEditTextColorGreen.text.toString()
            false -> mEditTextColorGreen.text.toString()
        }
        val blue = when (mEditTextColorBlue.text.toString().length == 1) {
            true -> "0" + mEditTextColorBlue.text.toString()
            false -> mEditTextColorBlue.text.toString()
        }
        val alpha = when (mEditTextAlpha.text.toString().length == 1) {
            true -> "0" + mEditTextAlpha.text.toString()
            false -> mEditTextAlpha.text.toString()
        }

        mImageViewRGBA.setColorFilter(Color.parseColor("#$alpha$red$green$blue"))

        when {
            seekBar!!.id == mSeekBarColorRed.id -> mSeekBarColorRed.progress = Integer.parseInt(red, 16)
            seekBar.id == mSeekBarColorGreen.id -> mSeekBarColorGreen.progress = Integer.parseInt(green, 16)
            seekBar.id == mSeekBarColorBlue.id -> mSeekBarColorBlue.progress = Integer.parseInt(blue, 16)
            seekBar.id == mSeekBarAlpha.id -> mSeekBarAlpha.progress = Integer.parseInt(alpha, 16)
        }
    }

    fun hexFilter(string: String): Boolean {

        for (c: Char in string){
            when (c) {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F' -> print("otherwise")
                else -> return false
            }
        }
        return true

    }


    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        val red = mSeekBarColorRed.progress
        val green = mSeekBarColorGreen.progress
        val blue = mSeekBarColorBlue.progress
        val alpha = mSeekBarAlpha.progress

        mImageViewRGBA.setColorFilter(Color.rgb(red, green, blue))
        mImageViewRGBA.alpha = alpha.toFloat()/255F

        if(mRadioButtonDecimal.isChecked) when {
            seekBar!!.id == mSeekBarColorRed.id -> mEditTextColorRed.setText("$red")
            seekBar.id == mSeekBarColorGreen.id -> mEditTextColorGreen.setText("$green")
            seekBar.id == mSeekBarColorBlue.id -> mEditTextColorBlue.setText("$blue")
            seekBar.id == mSeekBarAlpha.id -> mEditTextAlpha.setText(alpha.toString())
        } else if(mRadioButtonHexadecimal.isChecked) when {
            seekBar!!.id == mSeekBarColorRed.id -> mEditTextColorRed.setText(Integer.toHexString(red))
            seekBar.id == mSeekBarColorGreen.id -> mEditTextColorGreen.setText(Integer.toHexString(green))
            seekBar.id == mSeekBarColorBlue.id -> mEditTextColorBlue.setText(Integer.toHexString(blue))
            seekBar.id == mSeekBarAlpha.id -> mEditTextAlpha.setText(Integer.toHexString(alpha))
        }

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }


}
