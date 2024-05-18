package com.example.appnotaskotlin_sqlite_20083

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appnotaskotlin_sqlite_20083.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.FABAgregarNota.setOnClickListener{
            //Toast.makeText(applicationContext,
              //"Has presionado el boton",
            //Toast.LENGTH_SHORT).show()

            startActivity(Intent(applicationContext, AgregarNotaActivity::class.java))

        }
    }
}