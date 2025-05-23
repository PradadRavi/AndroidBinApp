package com.example.lucynumber

import android.content.Intent
import android.os.Bundle
import android.view.Menu
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
        val b1: Button = findViewById(R.id.button)
        val txt: TextView = findViewById(R.id.textView)
        val editText: EditText = findViewById(R.id.editTextText)
        b1.setOnClickListener() {
            var name = editText.text
            // Explicit Intents
            var i = Intent(this, LuckyNumberActivity::class.java)
            // passing the username
            i.putExtra("name", name)
            startActivity(i)
        }


    }

    //kotlin
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
        return super.onCreateOptionsMenu(menu)
    }
}