package com.example.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var firstNumber = ""
    private var secondNumber = ""
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        btn0.setOnClickListener { addDigit("0", tvResult) }
        btn1.setOnClickListener { addDigit("1", tvResult) }
        btn2.setOnClickListener { addDigit("2", tvResult) }
        btn3.setOnClickListener { addDigit("3", tvResult) }
        btn4.setOnClickListener { addDigit("4", tvResult) }
        btn5.setOnClickListener { addDigit("5", tvResult) }
        btn6.setOnClickListener { addDigit("6", tvResult) }
        btn7.setOnClickListener { addDigit("7", tvResult) }
        btn8.setOnClickListener { addDigit("8", tvResult) }
        btn9.setOnClickListener { addDigit("9", tvResult) }

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        btnPlus.setOnClickListener { operation = "+" }
        btnMinus.setOnClickListener { operation = "-" }
        btnMultiply.setOnClickListener { operation = "*" }
        btnDivide.setOnClickListener { operation = "/" }


        val btnEquals = findViewById<Button>(R.id.btnEquals)

        btnEquals.setOnClickListener {
            val num1 = firstNumber.toIntOrNull() ?: 0
            val num2 = secondNumber.toIntOrNull() ?: 0

            val result = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0) num1 / num2 else 0
                else -> 0
            }

            tvResult.text = result.toString()
            firstNumber = result.toString()
            secondNumber = ""
            operation = ""
        }
    }

    private fun addDigit(digit: String, tvResult: TextView) {
        if (operation.isEmpty()) {
            firstNumber += digit
            tvResult.text = firstNumber
        } else {
            secondNumber += digit
            tvResult.text = secondNumber
        }
    }
}