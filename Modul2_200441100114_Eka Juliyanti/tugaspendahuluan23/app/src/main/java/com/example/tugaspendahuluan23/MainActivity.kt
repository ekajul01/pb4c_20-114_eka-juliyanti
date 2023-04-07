package com.example.tugaspendahuluan23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardAdapter()
    }

    private fun cardAdapter(){
        val cards = listOf<CardModel>(
            CardModel(1,"Eka", R.drawable.bxl_android),
            CardModel(2,"Juliyanti", R.drawable.bxl_android),
            CardModel(3,"Agung", R.drawable.bxl_android),
            CardModel(4,"Ela", R.drawable.bxl_android),
            CardModel(5,"Dewi", R.drawable.bxl_android),
            CardModel(6,"Titin", R.drawable.bxl_android),
            CardModel(7,"Anis", R.drawable.bxl_android),
            CardModel(8,"Vina", R.drawable.bxl_android),
            CardModel(9,"Puti", R.drawable.bxl_android),
            CardModel(10,"Anggun", R.drawable.bxl_android),
            CardModel(11,"Tyas", R.drawable.bxl_android),
            CardModel(12,"Ferdi", R.drawable.bxl_android),
            CardModel(13,"Syakir", R.drawable.bxl_android),
            CardModel(14,"Leon", R.drawable.bxl_android),
            CardModel(15,"Jennie", R.drawable.bxl_android),
            CardModel(16,"Jihoon", R.drawable.bxl_android),
            CardModel(17,"Sehun", R.drawable.bxl_android),
            CardModel(18,"Sinta", R.drawable.bxl_android),
            CardModel(19,"Ahmad", R.drawable.bxl_android),
            CardModel(20,"Zea", R.drawable.bxl_android)
        )
        val cardAdapter = CardAdaptor( cards, object : CardAdaptor.OnAdapterListener{
            override fun onClick(card: CardModel) {
                val tampil = "Halo, ${card.name}"
                Toast.makeText(applicationContext, tampil, Toast.LENGTH_SHORT).show()
            }

        })
        findViewById<RecyclerView>(R.id.recyclerView).adapter = cardAdapter
    }
}