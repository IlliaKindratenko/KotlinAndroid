package com.example.labwork34


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.labwork34.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Оголошуємо змінну для ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ініціалізація ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Події для зміни кольору тексту при кліку на текстові поля
        setTextViewClickListener(binding.textViewInfo)
        setTextViewClickListener(binding.textViewGroup)
        setTextViewClickListener(binding.textViewCity)

        // Обробник натискання на кнопку "Сховати текст"
        binding.buttonHide.setOnClickListener {
            binding.textViewInfo.visibility = View.INVISIBLE
        }

        // Обробник натискання на кнопку "Показати текст"
        binding.buttonShow.setOnClickListener {
            binding.textViewInfo.visibility = View.VISIBLE
        }
    }

    // Функція для зміни кольору тексту при натисканні
    private fun setTextViewClickListener(textView: TextView) {
        textView.setOnClickListener {
            textView.setTextColor(Color.RED)
        }
    }
}