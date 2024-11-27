package com.example.kotlinn

import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page3 : AppCompatActivity() {
    private var isActive = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backBtn = findViewById<ImageView>(R.id.back)
        val starBtn = findViewById<ImageView>(R.id.star)
        backBtn.setOnClickListener {
            try{
                val intent = Intent(this, Page2::class.java)
                startActivity(intent)
                finish()
            }catch(e: ActivityNotFoundException){
                Toast.makeText(this,"Page 2 Not Found!!!", Toast.LENGTH_SHORT).show()
            }
        }
        starBtn.setOnClickListener {
            try{
                starBtn.setImageResource(R.drawable.starr)
            }catch(e: Exception){
                Toast.makeText(this,"Image Not Found!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}