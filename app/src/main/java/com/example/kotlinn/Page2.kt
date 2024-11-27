package com.example.kotlinn

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cardImage = findViewById<ImageView>(R.id.card1)

        cardImage.setOnClickListener{
            try{
                val intent = Intent(this, Page3::class.java)
                startActivity(intent)
                finish()
            }catch(e: ActivityNotFoundException){
                Toast.makeText(this,"Page 3 Not Found!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}