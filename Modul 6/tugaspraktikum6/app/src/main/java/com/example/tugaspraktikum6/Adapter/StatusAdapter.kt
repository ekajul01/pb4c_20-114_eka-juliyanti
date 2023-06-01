package com.example.tugaspraktikum6.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikum6.Model.StatusModel
import com.example.tugaspraktikum6.R

class StatusAdapter(
    private val statusList: List<StatusModel>
): RecyclerView.Adapter<StatusAdapter.StatusViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_status, parent, false)
        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        val status = statusList[position]
        holder.imageStatus.setImageResource(status.image)
        holder.nameStatus.text = status.name
        holder.dateStatus.text = status.time
    }

    override fun getItemCount(): Int {
        return statusList.size
    }
    class StatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageStatus : de.hdodenhof.circleimageview.CircleImageView = itemView.findViewById((R.id.fotostatus))
        val nameStatus : TextView = itemView.findViewById((R.id.namastatus))
        val dateStatus : TextView = itemView.findViewById((R.id.waktustatus))
    }

}
