package com.example.labwork31

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextProductName = findViewById<EditText>(R.id.editTextProductName)
        val editTextQuantity = findViewById<EditText>(R.id.editTextQuantity)
        val editTextPrice = findViewById<EditText>(R.id.editTextPrice)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewTotal = findViewById<TextView>(R.id.textViewTotal)

        // Додаємо обробник натискання кнопки
        buttonCalculate.setOnClickListener {
            // Отримуємо введені дані
            val quantityText = editTextQuantity.text.toString()
            val priceText = editTextPrice.text.toString()

            // Перевіряємо чи поля не порожні
            if (quantityText.isNotEmpty() && priceText.isNotEmpty()) {
                val quantity = quantityText.toInt()
                val price = priceText.toDouble()

                // Обчислюємо загальну вартість
                val totalCost = quantity * price

                // Відображаємо загальну вартість
                textViewTotal.text = "Загальна вартість: $totalCost грн"
            } else {
                textViewTotal.text = "Будь ласка, введіть всі дані."
            }
        }
    }
}