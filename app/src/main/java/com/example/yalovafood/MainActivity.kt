package com.example.yalovafood

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    private fun validateName(): Boolean? {
        val `val`: String = inputUsername.getEditText().getText().toString()
        return if (`val`.isEmpty()) {
            regName.setError("Field cannot be empty")
            false
        } else {
            regName.setError(null)
            regName.setErrorEnabled(false)
            true
        }
    }
}