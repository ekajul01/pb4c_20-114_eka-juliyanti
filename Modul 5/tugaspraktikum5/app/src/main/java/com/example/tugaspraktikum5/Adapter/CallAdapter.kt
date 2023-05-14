package com.example.tugaspraktikum5.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikum5.Data.CallModel
import com.example.tugaspraktikum5.R

class CallAdapter (
    private val callList: List<CallModel>
): RecyclerView.Adapter<CallAdapter.CallViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_call, parent, false)
        return CallViewHolder(view)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val call = callList[position]
        holder.imageCall.setImageResource(call.image)
        holder.nameCall.text = call.name
        holder.inoutCall.setBackgroundResource(call.inout)
        holder.dateCall.text = call.time
        holder.callvideoCall.setBackgroundResource(call.callvideo)
    }

    override fun getItemCount(): Int {
        return callList.size
    }
    class CallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCall : de.hdodenhof.circleimageview.CircleImageView = itemView.findViewById((R.id.fotocall))
        val nameCall : TextView = itemView.findViewById((R.id.namacall))
        val inoutCall : ImageButton = itemView.findViewById((R.id.inoutcall))
        val dateCall : TextView = itemView.findViewById((R.id.waktucall))
        val callvideoCall : Button = itemView.findViewById((R.id.callvideo))
    }
}
