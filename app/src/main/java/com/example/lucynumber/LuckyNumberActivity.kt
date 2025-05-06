package com.example.lucynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lucky_number)
        val text1: TextView = findViewById(R.id.firstText)
        val text2: TextView = findViewById(R.id.secondText)
        val btn: Button = findViewById(R.id.shareMyLuckyNum)

        var user_name = receiveUserName()

       Toast.makeText(this, ""+user_name,Toast.LENGTH_LONG).show()
        val random_num = generateRandomNum()
        text2.setText(""+random_num)

        btn.setOnClickListener(){
            shareData(user_name,random_num)
        }
    }

    fun receiveUserName(): String {
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }
    fun generateRandomNum():Int{
        val random = Random.nextInt(1000)
        return  random
    }

    // sharing the username & number
    fun shareData(userName: String , num : Int){
        // Imoplicit intent
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, ""+userName + "is lucky today")
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is $num")
        startActivity(i)
    }
}