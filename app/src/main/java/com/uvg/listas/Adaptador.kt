package com.uvg.listas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class Adaptador(private val clickListener: ItemsViewHolder.ClickListener): RecyclerView.Adapter<Adaptador.ItemsViewHolder>() {

    private var items: MutableList<Noticia> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(nuevosItems: MutableList<Noticia>){
        this.items = nuevosItems
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        this.items.removeAt(position)
        notifyItemRemoved(position)
    }
    fun reload(position: Int, aux:Noticia){
        this.items[position] = aux
        notifyItemChanged(position)
    }
    fun addItem(aux: Noticia) {
        this.items.add(aux)
        notifyDataSetChanged()
    }

    class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: Noticia, listener: ClickListener) = with(itemView) {
            txtTitulo.text = item.toString()

            setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
            setOnLongClickListener {
                listener.onItemLongClicked(adapterPosition)
            }
        }
            interface ClickListener{
                fun onItemClicked(position: Int)
                fun onItemLongClicked(position: Int):Boolean


            }
    }
}