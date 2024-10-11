package com.example.labwork33

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_INFO_TYPE = "com.example.infoapp.INFO_TYPE"
        const val EXTRA_FIRST_NAME = "com.example.infoapp.FIRST_NAME"
        const val EXTRA_LAST_NAME = "com.example.infoapp.LAST_NAME"
        const val EXTRA_AGE = "com.example.infoapp.Age"
        const val INFO_AUTHOR = "AUTHOR"
        const val INFO_FACULTY = "FACULTY"
        const val INFO_CITY = "CITY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Пошук елементів інтерфейсу за ID
        val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)

        val buttonAuthor: Button = findViewById(R.id.buttonAuthor)
        val buttonFaculty: Button = findViewById(R.id.buttonFaculty)
        val buttonCity: Button = findViewById(R.id.buttonCity)

        buttonAuthor.setOnClickListener {
            val firstName = editTextFirstName.text.toString()
            val lastName = editTextLastName.text.toString()
            val age = editTextAge.text.toString()
            openDetailActivity(INFO_AUTHOR, firstName, lastName, age)
        }

        buttonFaculty.setOnClickListener {
            openDetailActivity(INFO_FACULTY, null, null, null)
        }

        buttonCity.setOnClickListener {
            openDetailActivity(INFO_CITY, null, null, null)
        }
    }

    private fun openDetailActivity(infoType: String, firstName: String?, lastName: String?, age: String?) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA_INFO_TYPE, infoType)
            putExtra(EXTRA_FIRST_NAME, firstName)
            putExtra(EXTRA_LAST_NAME, lastName)
            putExtra(EXTRA_AGE, age)
        }
        startActivity(intent)
    }
}