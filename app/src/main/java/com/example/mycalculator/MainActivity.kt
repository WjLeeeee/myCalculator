package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private val backText by lazy { findViewById<TextView>(R.id.text_back)}
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
        clearText.setOnClickListener {
            finalText.setText("0")
        }
        zeroText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("0")
            }else{
                var newNum = currentNum+"0"
                finalText.setText(newNum)
            }
        }
        oneText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("1")
            }else{
                var newNum = currentNum+"1"
                finalText.setText(newNum)
            }
        }
        twoText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("2")
            }else{
                var newNum = currentNum+"2"
                finalText.setText(newNum)
            }
        }
        threeText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("3")
            }else{
                var newNum = currentNum+"3"
                finalText.setText(newNum)
            }
        }
        fourText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("4")
            }else{
                var newNum = currentNum+"4"
                finalText.setText(newNum)
            }
        }
        fiveText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("5")
            }else{
                var newNum = currentNum+"5"
                finalText.setText(newNum)
            }
        }
        sixText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("6")
            }else{
                var newNum = currentNum+"6"
                finalText.setText(newNum)
            }
        }
        sevenText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("7")
            }else{
                var newNum = currentNum+"7"
                finalText.setText(newNum)
            }
        }
        eightText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("8")
            }else{
                var newNum = currentNum+"8"
                finalText.setText(newNum)
            }
        }
        nineText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(finalText.text == "0"){
                finalText.setText("9")
            }else{
                var newNum = currentNum+"9"
                finalText.setText(newNum)
            }
        }
        comaText.setOnClickListener {
            val currentNum = finalText.text.toString()
            if(currentNum.contains("+")||currentNum.contains("-")||currentNum.contains("*")||currentNum.contains("/")||currentNum.contains("%")){
                var newNum = currentNum+"."
                finalText.setText(newNum)
            }else if(currentNum.contains(".")){
                finalText.setText(currentNum)
            }else{
                var newNum = currentNum+"."
                finalText.setText(newNum)
            }
        }
        backText.setOnClickListener {
            var currentNum = finalText.text.toString()
            if(currentNum != "0"){
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum)
            }else{
                finalText.setText(currentNum)
            }
        }
        plusText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            //제일 마지막이 연산자일경우, 연산자중복으로 사용못하게.
            if(currentNum.toCharArray().last() == '+'){
                finalText.setText(currentNum)
            }else if(currentNumLast == '-' || currentNumLast == '*' || currentNumLast == '/' || currentNumLast == '%'){
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "+")
            }
            else{
                firstNum = currentNum
                operator = "+"
                var newNum = currentNum + "+"
                finalText.setText(newNum)
            }
        }
        subText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if(currentNum.toCharArray().last() == '-'){
                finalText.setText(currentNum)
            }else if(currentNumLast == '+' || currentNumLast == '*' || currentNumLast == '/' || currentNumLast == '%'){
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "-")
            }else{
                firstNum = currentNum
                operator = "-"
                var newNum = currentNum + "-"
                finalText.setText(newNum)
            }
        }
        multiText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if(currentNum.toCharArray().last() == '*'){
                finalText.setText(currentNum)
            }else if(currentNumLast == '+' || currentNumLast == '-' || currentNumLast == '/' || currentNumLast == '%'){
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "*")
            }else{
                firstNum = currentNum
                operator = "*"
                var newNum = currentNum + "*"
                finalText.setText(newNum)
            }
        }
        divText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if(currentNum.toCharArray().last() == '/'){
                finalText.setText(currentNum)
            }else if(currentNumLast == '+' || currentNumLast == '-' || currentNumLast == '*' || currentNumLast == '%'){
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "/")
            }else{
                firstNum = currentNum
                operator = "/"
                var newNum = currentNum + "/"
                finalText.setText(newNum)
            }
        }
        remainText.setOnClickListener {
            var currentNum = finalText.text.toString()
            var currentNumLast = currentNum.toCharArray().last()
            if(currentNum.toCharArray().last() == '%'){
                finalText.setText(currentNum)
            }else if(currentNumLast == '+' || currentNumLast == '-' || currentNumLast == '*' || currentNumLast == '/'){
                var newCurrentNum = currentNum.dropLast(1)
                finalText.setText(newCurrentNum + "%")
            }else{
                firstNum = currentNum
                operator = "%"
                var newNum = currentNum + "%"
                finalText.setText(newNum)
            }
        }
        resultText.setOnClickListener {
            var currentNum = finalText.text.toString()
            when{
                operator == "+" -> {
                    val parts = currentNum.split(operator)
                    if(parts[0].contains(".")||parts[1].contains(".")){
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0+part1
                        //result를 1로 나눈 나머지가 0인지 확인한다. 0이면 소수점 없애기.
                        if (result.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                            result = result.setScale(0, RoundingMode.DOWN)
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }else{
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }
                    }
                    else{
                        val result = parts[0].toInt()+parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }
                operator == "-" -> {
                    val parts = currentNum.split(operator)
                    if(parts[0].contains(".")||parts[1].contains(".")){
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0-part1
                        if (result.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                            result = result.setScale(0, RoundingMode.DOWN)
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }else{
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }

                    }else{
                        val result = parts[0].toInt()-parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }
                operator == "*" -> {
                    val parts = currentNum.split(operator)
                    if(parts[0].contains(".")||parts[1].contains(".")){
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0*part1
                        if (result.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                            result = result.setScale(0, RoundingMode.DOWN)
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }else{
                            finalText.setText(result.toString())
                            firstNum = ""
                            operator = ""
                            lastNum = ""
                        }
                    }else{
                        val result = parts[0].toInt()*parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }
                operator == "/" -> {
                    val parts = currentNum.split(operator)
                    if(parts[0].contains(".")||parts[1].contains(".")){
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
                    }else{
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        val value = (part0.divide(part1, part0.scale() + part1.scale(), RoundingMode.DOWN)).stripTrailingZeros().toString()
                        finalText.setText(value)
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }
                operator == "%" -> {
                    val parts = currentNum.split(operator)
                    if(parts[0].contains(".")||parts[1].contains(".")){
                        val front = parts[0].toDouble().toString()
                        val back = parts[1].toDouble().toString()
                        val part0 = BigDecimal(front)
                        val part1 = BigDecimal(back)
                        var result = part0%part1
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }else{
                        val result = parts[0].toInt()%parts[1].toInt()
                        finalText.setText(result.toString())
                        firstNum = ""
                        operator = ""
                        lastNum = ""
                    }
                }
                else -> {finalText.setText(currentNum)}
            }
        }

    }
}
//부동 소수점오류