package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt0.setOnClickListener {
            raqamYoz(0)
        }
        bt1.setOnClickListener {
            raqamYoz(1)
        }
        bt2.setOnClickListener {
            raqamYoz(2)
        }
        bt3.setOnClickListener {
            raqamYoz(3)
        }
        bt4.setOnClickListener {
            raqamYoz(4)
        }
        bt5.setOnClickListener {
            raqamYoz(5)
        }
        bt6.setOnClickListener {
            raqamYoz(6)
        }
        bt7.setOnClickListener {
            raqamYoz(7)
        }
        bt8.setOnClickListener {
            raqamYoz(8)
        }
        bt9.setOnClickListener {
            raqamYoz(9)
        }
        bt_tochka.setOnClickListener {
            math_opeation.text="${math_opeation.text}."
        }

        plus.setOnClickListener {
           plus("+")
        }
        minus.setOnClickListener {
            minus("-")
        }
        bt_umnojeniye.setOnClickListener {
           umnojeniye("*")
        }
        deleniye.setOnClickListener {
            deleniye("/")
        }
        bt_ravno.setOnClickListener {
            hisobla()
        }
        bt_ac.setOnClickListener {
            math_opeation.text = "0"
            result_text.text = ""
        }
        bt_back.setOnClickListener {
            if (math_opeation.text.toString()!="0" && math_opeation.text.toString()!=""){
                val ekran2 = math_opeation.text.substring(0, math_opeation.text.length-1)
                math_opeation.text = ekran2
                result_text.text = ""
            }else{
                math_opeation.text = ""
            }
        }
        bt_skobka1.setOnClickListener{
            skobka1("(")
        }
        bt_skobka2.setOnClickListener {
            skobka2(")")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun hisobla(){
        try {
            var amal1 = -1
            var amalIndex = -1
            val ekranString = math_opeation.text.toString()
            for (i in ekranString.indices) {
                when (ekranString[i]){
                    '+'->{
                        amal1 = 0
                        amalIndex = i
                    }
                    '-'->{
                        amal1 = 1
                        amalIndex = i
                    }
                    '*'->{
                        amal1 = 2
                        amalIndex = i
                    }
                    '/'->{
                        amal1 = 3
                        amalIndex = i
                    }
                }
            }
            val number1 = ekranString.substring(0, amalIndex).toDouble()
            val number2 = ekranString.substring(amalIndex+1, ekranString.length).toDouble()

            when (amal1) {
                0 -> {
                    result_text.text = "${number1+number2}"

                }
                1 -> {
                    result_text.text = "${number1-number2}"

                }
                2 -> {
                    result_text.text = "${number1*number2}"

                }
                3 -> {
                    result_text.text = "${number1/number2}"

                }

            }
        }catch (e:Exception){
            Toast.makeText(this, "son yozing", Toast.LENGTH_SHORT).show()
        }
    }

    fun raqamYoz(raqam:Int){
        if (math_opeation.text.toString()!="0"){
            math_opeation.text="${math_opeation.text}$raqam"
        }
        else{
            math_opeation.text="$raqam"
        }
    }


    fun skobka1 (sk:String){
        try {
            if (math_opeation.text.last().toString()!="("){
                math_opeation.text = "${math_opeation.text}$sk"
            }
        }catch (e:Exception){
            Toast.makeText(this, "son kiriting", Toast.LENGTH_SHORT).show()
        }

    }


    fun skobka2 (sk:String){
        try {
            if (math_opeation.text.last().toString()!=")" && math_opeation.text.toString()!=""){
                math_opeation.text = "${math_opeation.text}$sk"
            }
        }catch (e:Exception){
            Toast.makeText(this, "son kiriting", Toast.LENGTH_SHORT).show()
        }
    }

    fun umnojeniye (umn:String){
        try {

            if (math_opeation.text.last().toString()!="*" && math_opeation.text!=""){
                math_opeation.text = "${math_opeation.text}$umn"
            }
        }catch (e:Exception){
            Toast.makeText(this, "son kiriting", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleniye (del:String){
        try {
            if (math_opeation.text.last().toString()!="/" && math_opeation.text!="" && math_opeation.text!="0"){
                math_opeation.text = "${math_opeation.text}$del"
            }
        }catch (e:Exception){
            Toast.makeText(this, "son kiriting", Toast.LENGTH_SHORT).show()
        }
    }

    fun plus (plus:String){
        try {
            if (math_opeation.text.last().toString()!="+" && math_opeation.text!=""){
                math_opeation.text = "${math_opeation.text}$plus"
            }
        }catch (e:Exception){
            Toast.makeText(this, "son kiriting", Toast.LENGTH_SHORT).show()
        }

    }
    fun minus (min:String){
        try {
            if (math_opeation.text.last().toString()!="-" && math_opeation.text!=""){
                math_opeation.text = "${math_opeation.text}$min"
            }
        }catch (e:Exception){
            Toast.makeText(this, "son kiriting", Toast.LENGTH_SHORT).show()
        }

    }
}

