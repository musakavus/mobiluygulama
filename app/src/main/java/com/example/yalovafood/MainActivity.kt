package com.example.yalovafood

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    private val emailLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()
    private val isValiddata = MediatorLiveData<Boolean>().apply {
        this.value = false
        addSource(emailLiveData){
            email ->
            val password = passwordLiveData.value
            this.value = validateForm(email, password)

        }

        addSource(passwordLiveData){
            password ->
            val email = emailLiveData.value
            this.value = validateForm(email, password)

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val emailLayout = findViewById<TextInputLayout>(R.id.inputUsername)
        val passwordLayout = findViewById<TextInputLayout>(R.id.inputPassword)
        val signInButton = findViewById<Button>(R.id.btnRegister)

        emailLayout.editText?.doOnTextChanged { text, _, _, _ ->
            emailLiveData.value = text?.toString()
        }

        passwordLayout.editText?.doOnTextChanged { text, _, _, _ ->
            passwordLiveData.value = text?.toString()
        }

       isValiddata.observe(this){
           isValid ->
           signInButton.isEnabled = isValid
           val secondButton = findViewById<Button>(R.id.btnRegister)
           secondButton.setOnClickListener{
               val intent2 = Intent(this, OrderActivity::class.java)
               startActivity(intent2)
           }
       }


    }

    private fun validateForm(email: String?, password: String?) : Boolean{
        val isValidEmail = email != null && email.isNotBlank() && email.contains("@")
        val isValidPassword = password != null && password.isNotBlank() && password.length >=8
        return isValidEmail && isValidPassword
    }
}