package com.uvg.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Adaptador.ItemsViewHolder.ClickListener {


    private val adaptador = Adaptador(this)
    private val items : MutableList<Noticia> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Add_btn: Button = findViewById(R.id.Add_btn)

        Add_btn.setOnClickListener{
            val aux = Noticia("Prueba")
            adaptador.addItem(aux)
        }


        val items : MutableList<Noticia> = mutableListOf()
        adaptador.setItems(items)


        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }



    override fun onItemClicked(position: Int) {
        adaptador.removeItem(position)
    }
    override fun onItemLongClicked(position: Int) : Boolean{
        val aux = Noticia(
                titulo = "Actualizando"
        )
        adaptador.reload(position,aux)
        return true
    }

}