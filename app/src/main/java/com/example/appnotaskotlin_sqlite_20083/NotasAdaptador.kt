package com.example.appnotaskotlin_sqlite_20083

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class NotasAdaptador (

    private var notas : List<Nota>,
            context: Context): RecyclerView.Adapter<NotasAdaptador.NotaViewHolder>(){

    private val db : NotasDatabaseHelper = NotasDatabaseHelper(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nota,
            parent,false)
        return NotaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notas.size
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
            val nota = notas[position]
            holder.itemTitulo.text = nota.titulo
            holder.itemDescripcion.text = nota.descripcion

    }

            class NotaViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
                val itemTitulo: TextView = itemView.findViewById(R.id.item_titulo)
                val itemDescripcion: TextView = itemView.findViewById(R.id.item_descripion)
            }

            fun refrescarLista (nuevaNota : List<Nota>){
                notas = nuevaNota
                notifyDataSetChanged()
            }

}