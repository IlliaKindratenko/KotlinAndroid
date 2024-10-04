package com.example.labwork31

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Знайдемо всі необхідні віджети за їх ID
        val editTextDate = findViewById<EditText>(R.id.editTextDate)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        val textViewDay = findViewById<TextView>(R.id.textViewDay)
        val textViewMonth = findViewById<TextView>(R.id.textViewMonth)
        val textViewYear = findViewById<TextView>(R.id.textViewYear)

        // Додаємо обробник натискання кнопки
        buttonSubmit.setOnClickListener {
            // Отримуємо введену дату у вигляді рядка
            val dateInput = editTextDate.text.toString()

            // Перевіряємо чи введена дата має правильний формат (ДД.ММ.РР)
            if (dateInput.matches(Regex("\\d{2}.\\d{2}.\\d{4}"))) {
                // Розбиваємо дату на частини (день, місяць, рік)
                val dateParts = dateInput.split(".")
                val day = dateParts[0]
                val month = dateParts[1]
                val year = dateParts[2]

                // Відображаємо значення дня, місяця та року у відповідних TextView
                textViewDay.text = "День: $day"
                textViewMonth.text = "Місяць: $month"
                textViewYear.text = "Рік: $year"
            } else {
                // Якщо формат дати неправильний, виводимо повідомлення про помилку
                textViewDay.text = "Неправильний формат дати"
                textViewMonth.text = ""
                textViewYear.text = ""
            }
        }
    }
}