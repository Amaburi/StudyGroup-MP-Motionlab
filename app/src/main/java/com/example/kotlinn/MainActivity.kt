package com.example.kotlinn

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG = "Login Activity"
    private var isVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameTextField = findViewById<EditText>(R.id.TextSearch)
        val passwordTextField = findViewById<EditText>(R.id.TextPassword)
        val iconMata = findViewById<ImageView>(R.id.ToggleEye)
        val LoginBtn = findViewById<Button>(R.id.LoginBtn)
         LoginBtn.setOnClickListener {
             var username = usernameTextField.text.toString()
             var password = passwordTextField.text.toString()

             if (username.isEmpty() && password.isEmpty()) {
                 Toast.makeText(this,"Username Dan Password tidak boleh kosong!!", Toast.LENGTH_SHORT).show()
                 Log.e(this.toString(), "Login Error");
             }else{
                val intent = Intent(this, Page2::class.java)
                 startActivity(intent)
                 finish()
             }
         }
        iconMata.setOnClickListener{
            isVisible = true
            if (isVisible){
                passwordTextField.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                iconMata.setImageResource(R.drawable.visible)
            }else{
                passwordTextField.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                iconMata.setImageResource(R.drawable.hidden)
            }
            passwordTextField.setSelection(passwordTextField.text.length)
        }
    }
}