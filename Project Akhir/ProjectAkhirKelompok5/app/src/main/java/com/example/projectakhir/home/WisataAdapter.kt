package com.example.projectakhir.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.R
import com.example.projectakhir.data.entity.Wisataku

class WisataAdapter (var list:List<Wisataku>): RecyclerView.Adapter<WisataAdapter.ViewHolder>() {
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog) {
        this.dialog = dialog
    }

    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtnama: TextView
        var txtjarak: TextView
        var txtharga: TextView
        var txtkendaraan: TextView

        init {
            txtnama = view.findViewById(R.id.txttampilnamawisata)
            txtjarak = view.findViewById(R.id.txttampiljarakwisata)
            txtharga = view.findViewById(R.id.txttampilhargawisata)
            txtkendaraan = view.findViewById(R.id.txttampilkendaraanwisata)
            view.setOnClickListener {
                dialog.onClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listwisata, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtnama.text = list[position].namawisata
        holder.txtjarak.text = list[position].jarakwisata.toString()
        holder.txtharga.text = list[position].hargawisata.toString()
        holder.txtkendaraan.text = list[position].kendaraan.toString()
    }
}