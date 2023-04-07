package com.example.tugaspendahuluan23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdaptor(
    private val listCard: List<CardModel>,
    private val listener: OnAdapterListener
) : RecyclerView.Adapter<CardAdaptor.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdaptor.ViewHolder {
        return ViewHolder(
            LayoutInflater.from( parent.context ).inflate( R.layout.activity_main_card, parent,false )
        )
    }

    override fun onBindViewHolder(holder: CardAdaptor.ViewHolder, position: Int) {
        val card = listCard[position]
        holder.imageView.setImageResource( card.image )
        holder.textName.text = card.name
        holder.itemView.setOnClickListener {
            listener.onClick( card )
        }
    }

    override fun getItemCount(): Int {
        return listCard.size
    }

    class ViewHolder( view: View): RecyclerView.ViewHolder( view ){
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textName = view.findViewById<TextView>(R.id.textName)
    }

    interface OnAdapterListener{
        fun onClick(card: CardModel)
    }

}