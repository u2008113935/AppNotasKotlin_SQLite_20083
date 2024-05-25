package com.example.appnotaskotlin_sqlite_20083

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnotaskotlin_sqlite_20083.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db : NotasDatabaseHelper
    private lateinit var notasAdaptador: NotasAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDatabaseHelper(this)

        notasAdaptador = NotasAdaptador(db.getAllNotas(), this)

        binding.notasRv.layoutManager = LinearLayoutManager(this)
        binding.notasRv.adapter = notasAdaptador

        binding.FABAgregarNota.setOnClickListener{
            //Toast.makeText(applicationContext,
              //"Has presionado el boton",
            //Toast.LENGTH_SHORT).show()

            startActivity(Intent(applicationContext, AgregarNotaActivity::class.java))

        }
    }

    fun onResumen(){
        super.onResume()
        notasAdaptador.refrescarLista(db.getAllNotas())
    }

}