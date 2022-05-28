package com.ktl1.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameText: EditText
    private lateinit var ageText: EditText

    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.name)
        ageText = findViewById(R.id.age)

//        var sf = getSharedPreferences("my_sf", MODE_PRIVATE)

        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()

        val button = findViewById<Button>(R.id.button)
    }

    override fun onPause() {
        super.onPause()

        val name = nameText.text.toString()
        val age = ageText.text.toString().toInt()

        editor.apply {
            putString("sf_name", name)
            putInt("sf_age", age)
            commit()
        }

    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name",null)
        val age = sf.getInt("sf_age",0)
        nameText.setText(name)
        ageText.setText(age.toString())
    }
}