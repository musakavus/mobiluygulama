package com.example.yalovafood

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val secondButton = findViewById<Button>(R.id.btnRegister)
        secondButton.setOnClickListener{
            val intent2 = Intent(this, OrderActivity::class.java)
            startActivity(intent2)
        }


    }
}