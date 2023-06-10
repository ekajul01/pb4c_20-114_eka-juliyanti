package com.example.projectakhir.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.R
import com.example.projectakhir.data.entity.Kriteria

class KriteriaAdapter (var list:List<Kriteria>): RecyclerView.Adapter<KriteriaAdapter.ViewHolder>() {
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog) {
        this.dialog = dialog
    }

    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textnamakriteria: TextView
        var texttampilkepentingan: TextView
        var texttampilatribut: TextView

        init {
            textnamakriteria = view.findViewById(R.id.txttampilnamakriteria)
            texttampilkepentingan = view.findViewById(R.id.txttampilkepentingan)
            texttampilatribut = view.findViewById(R.id.txttampilatribut)
            view.setOnClickListener {
                dialog.onClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listkriteria, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textnamakriteria.text = list[position].namakriteria
        holder.texttampilkepentingan.text = list[position].kepentingan.toString()
        holder.texttampilatribut.text = list[position].atribut.toString()
    }
}