package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private val backText by lazy { findViewById<TextView>(R.id.text_back) }
    private val finalText by lazy { findViewById<TextView>(R.id.final_text) }
    private val clearText by lazy { findViewById<TextView>(R.id.text_clear) }
    private val resultText by lazy { findViewById<TextView>(R.id.text_result) }
    private val remainText by lazy { findViewById<TextView>(R.id.text_remain) }
    private val plusText by lazy { findViewById<TextView>(R.id.text_plus) }
    private val subText by lazy { findViewById<TextView>(R.id.text_sub) }
    private val multiText by lazy { findViewById<TextView>(R.id.text_multi) }
    private val divText by lazy { findViewById<TextView>(R.id.text_div) }
    private val zeroText by lazy { findViewById<TextView>(R.id.text_0) }
    private val oneText by lazy { findViewById<TextView>(R.id.text_1) }
    private val twoText by lazy { findViewById<TextView>(R.id.text_2) }
    private val threeText by lazy { findViewById<TextView>(R.id.text_3) }
    private val fourText by lazy { findViewById<TextView>(R.id.text_4) }
    private val fiveText by lazy { findViewById<TextView>(R.id.text_5) }
    private val sixText by lazy { findViewById<TextView>(R.id.text_6) }
    private val sevenText by lazy { findViewById<TextView>(R.id.text_7) }
    private val eightText by lazy { findViewById<TextView>(R.id.text_8) }
    private val nineText by lazy { findViewById<TextView>(R.id.text_9) }
    private val comaText by lazy { findViewById<TextView>(R.id.text_coma) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstNum = ""
        var lastNum = ""
        var operator = ""
        zeroText.setOnClickListener { clickListener("0") }
        oneText.setOnClickListener { clickListener("1") }
        twoText.setOnClickListener { clickListener("2") }
        threeText.setOnClickListener { clickListener("3") }
        fourText.setOnClickListener { clickListener("4") }
        fiveText.setOnClickListener { clickListener("5") }
        sixText.setOnClickListener { clickListener("6") }
        sevenText.setOnClickListener { clickListener("7") }
        eightText.setOnClickListener { clickListener("8") }
        nineText.setOnClickListener { clickListener("9") }
        clearText.setOnClickListener { finalText.setText("0") }
        comaText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(currentNum.last().toString() == "."){
                finalText.setText(currentNum)
            }
            else if (currentNum.contains(".")) {
                if(!currentNum.contains("+") && !currentNum.contains("-") && !currentNum.contains("*") &&
                    !currentNum.contains("/") && !currentNum.contains("%")){
                    finalText.setText(currentNum)
                }else{
                    if(currentNum.contains("+")){
                        var numSplit = currentNum.split("+")
                        if(numSplit[1].contains(".")){
                            finalText.setText(currentNum)
                        }else{
                            var newNum = currentNum + "."
                            finalText.setText(newNum)
                        }
                    }
                    if(currentNum.contains("-")){
                        var numSplit = currentNum.split("-")
                        if(numSplit[1].contains(".")){
                            finalText.setText(currentNum)
                        }else{
                            var newNum = currentNum + "."
                            finalText.setText(newNum)
                        }
                    }
                    if(currentNum.contains("*")){
                        var numSplit = currentNum.split("*")
                        if(numSplit[1].contains(".")){
                            finalText.setText(currentNum)
                        }else{
                            var newNum = currentNum + "."
                            finalText.setText(newNum)
                        }
                    }
                    if(currentNum.contains("/")){
                        var numSplit = currentNum.split("/")
                        if(numSplit[1].contains(".")){
                            finalText.setText(currentNum)
                        }else{
                            var newNum = currentNum + "."
                            finalText.setText(newNum)
                        }
                    }
                    if(currentNum.contains("%")){
                        var numSplit = currentNum.split("%")
                        if(numSplit[1].contains(".")){
                            finalText.setText(currentNum)
                        }else{
                            var newNum = currentNum + "."
                            finalText.setText(newNum)
                        }
                    }
                }
            } else {
                var newNum = currentNum + "."
                finalText.setText(newNum)
            }
        }
        backText.setOnClickListener {
            var currentNum = finalText.text.toString()
            if (currentNum != "0") {
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum)
            } else {
                finalText.setText(currentNum)
            }
        }
        plusText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            //제일 마지막이 연산자일경우, 연산자중복으로 사용못하게.
            if (currentNum.toCharArray().last() == '+') {
                finalText.setText(currentNum)
            } else if (currentNumLast == '-' || currentNumLast == '*' || currentNumLast == '/' || currentNumLast == '%') {
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "+")
            } else {
                firstNum = currentNum
                operator = "+"
                var newNum = currentNum + "+"
                finalText.setText(newNum)
            }
        }
        subText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if (currentNum.toCharArray().last() == '-') {
                finalText.setText(currentNum)
            } else if (currentNumLast == '+' || currentNumLast == '*' || currentNumLast == '/' || currentNumLast == '%') {
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "-")
            } else {
                firstNum = currentNum
                operator = "-"
                var newNum = currentNum + "-"
                finalText.setText(newNum)
            }
        }
        multiText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if (currentNum.toCharArray().last() == '*') {
                finalText.setText(currentNum)
            } else if (currentNumLast == '+' || currentNumLast == '-' || currentNumLast == '/' || currentNumLast == '%') {
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "*")
            } else {
                firstNum = currentNum
                operator = "*"
                var newNum = currentNum + "*"
                finalText.setText(newNum)
            }
        }
        divText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if (currentNum.toCharArray().last() == '/') {
                finalText.setText(currentNum)
            } else if (currentNumLast == '+' || currentNumLast == '-' || currentNumLast == '*' || currentNumLast == '%') {
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "/")
            } else {
                firstNum = currentNum
                operator = "/"
                var newNum = currentNum + "/"
                finalText.setText(newNum)
            }
        }
        remainText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if (currentNum.toCharArray().last() == '%') {
                finalText.setText(currentNum)
            } else if (currentNumLast == '+' || currentNumLast == '-' || currentNumLast == '*' || currentNumLast == '/') {
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "%")
            } else {
                firstNum = currentNum
                operator = "%"
                var newNum = currentNum + "%"
                finalText.setText(newNum)
            }
        }
        resultText.setOnClickListener {
            var currentNum = finalText.text.toString()
            when {
                operator == "+" -> {
                    val parts = currentNum.split(operator)
                    if (parts[0].contains(".") || parts[1].contains(".")) {
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0 + part1
                        //result를 1로 나눈 나머지가 0인지 확인한다. 0이면 소수점 없애기.
                        if (result.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                            result = result.setScale(0, RoundingMode.DOWN)
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        } else {
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }
                    } else {
                        val result = parts[0].toInt() + parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }

                operator == "-" -> {
                    val parts = currentNum.split(operator)
                    if (parts[0].contains(".") || parts[1].contains(".")) {
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0 - part1
                        if (result.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                            result = result.setScale(0, RoundingMode.DOWN)
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        } else {
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }

                    } else {
                        val result = parts[0].toInt() - parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }

                operator == "*" -> {
                    val parts = currentNum.split(operator)
                    if (parts[0].contains(".") || parts[1].contains(".")) {
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0 * part1
                        if (result.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                            result = result.setScale(0, RoundingMode.DOWN)
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        } else {
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }
                    } else {
                        val result = parts[0].toInt() * parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }

                operator == "/" -> {
                    val parts = currentNum.split(operator)
                    if (parts[0].contains(".") || parts[1].contains(".")) {
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        //결과값을 소수점 한자리만 표현, 나머지는 반올림.
                        val value = (part0.divide(part1, 1, RoundingMode.DOWN)).toString()
                        finalText.setText(value)
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    } else {
                        val front = parts[0].toInt()
                        val back = parts[1].toInt()
                        val value = front.toDouble() / back.toDouble()
                        finalText.setText(value.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }

                operator == "%" -> {
                    val parts = currentNum.split(operator)
                    if (parts[0].contains(".") || parts[1].contains(".")) {
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0 % part1
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    } else {
                        val result = parts[0].toInt() % parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }

                else -> {
                    finalText.setText(currentNum)
                }
            }
        }

    }
    fun clickListener(clickedNumber: String) {
        val currentNum = finalText.text.toString()
        if (finalText.text == "0") {
            finalText.setText(clickedNumber)
        } else {
            val newNum = currentNum + clickedNumber
            finalText.setText(newNum)
        }
    }
}
