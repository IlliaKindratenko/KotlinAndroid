package com.example.labwork33

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textView = findViewById<TextView>(R.id.textViewDetail)

        val infoType = intent.getStringExtra(MainActivity.EXTRA_INFO_TYPE)
        val firstName = intent.getStringExtra(MainActivity.EXTRA_FIRST_NAME)
        val lastName = intent.getStringExtra(MainActivity.EXTRA_LAST_NAME)
        val age = intent.getStringExtra(MainActivity.EXTRA_AGE)

        when (infoType) {
            MainActivity.INFO_AUTHOR -> {
                textView.text = "Автор: $firstName $lastName\nВік: $age"
            }
            MainActivity.INFO_FACULTY -> {
                textView.text = """Факультет: ФІТ
                    |Група: 4-7
                    |Навч.заклад: ДТЕУ
                """.trimMargin()
            }
            MainActivity.INFO_CITY -> {
                textView.text = """Місто: смт.Іванків
                    |Район: Вишгородський
                    |Область: Київська
                """.trimMargin()
            }
        }
    }
}
