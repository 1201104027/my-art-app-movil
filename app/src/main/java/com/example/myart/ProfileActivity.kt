package com.example.myart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {

    lateinit var home: ImageView
    lateinit var settings: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        home = findViewById(R.id.iv_home)
        settings = findViewById(R.id.iv_settings)

        home.setOnClickListener{
            Toast.makeText(this, "home.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        settings.setOnClickListener{
            Toast.makeText(this, "home.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i)
        }
    }
}