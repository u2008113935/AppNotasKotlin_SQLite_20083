package com.example.appnotaskotlin_sqlite_20083

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appnotaskotlin_sqlite_20083.databinding.ActivityAgregarNotaBinding
import com.example.appnotaskotlin_sqlite_20083.databinding.ActivityMainBinding

class AgregarNotaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgregarNotaBinding
    private lateinit var db: NotasDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db =  NotasDatabaseHelper(this)

        binding.ivGuardarNota.setOnClickListener{
            val titulo = binding.etTitulo.text.toString()
            val descripcion = binding.etDescripcion.text.toString()

            if (!titulo.isEmpty() && !descripcion.isEmpty()){
                guardaNota(titulo, descripcion)
            }  else {
                Toast.makeText(applicationContext,
                    "Debe completar los campos por favor",
                    Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun guardaNota(titulo: String, descripcion: String) {
        val nota = Nota (0, titulo, descripcion)
        db.insertNota(nota)
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finishAffinity()
        Toast.makeText(applicationContext,
            "Se agregó la nota satisfactoriamente",
            Toast.LENGTH_SHORT).show()
    }
}