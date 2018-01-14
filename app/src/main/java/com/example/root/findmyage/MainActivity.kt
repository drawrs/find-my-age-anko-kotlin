package com.example.root.findmyage

import android.graphics.Typeface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.InputType
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // View group
        verticalLayout {
            topPadding = 20
            gravity = Gravity.CENTER_HORIZONTAL
            // TextView untuk menampilkan hasil penghitungan Umur
            textView {
                text = "Your age is :"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams {
                width = matchParent
            }
            var resultAge = textView {
                text = "0"
                textSize = 150F
                typeface = Typeface.DEFAULT_BOLD
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams {
                width = matchParent
            }
            // EditText utuk Input tahun lahir
            val birthYear = editText {
                hint = "Enter year"
                inputType = InputType.TYPE_CLASS_NUMBER
            }.lparams {
                width = matchParent
                height = wrapContent
                gravity = Gravity.CENTER
                leftMargin = 10
                rightMargin = 10
            }
            // Button untuk Triger penghitungan Umur
            val btnFind = button {
                text = "Find My Age !"
                // Memberi Event OnClick pada button
                onClick {
                    // Dapatkan tahun yang di inputkan
                    val year = birthYear.text.toString().toInt()
                    // Dapatkan tahun sekarang, kurangi dngan variable year
                    val age = Calendar.getInstance().get(Calendar.YEAR) - year;
                    // Set hasil umur ke TextView
                    resultAge.text = age.toString()
                }
            }.lparams {
                topMargin = 10
                width = wrapContent
            }
        }
    }
}
