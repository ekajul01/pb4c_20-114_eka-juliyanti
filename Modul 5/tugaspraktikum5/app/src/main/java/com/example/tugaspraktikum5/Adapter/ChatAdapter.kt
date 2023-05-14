package com.example.tugaspraktikum5.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikum5.Data.ChatModel
import com.example.tugaspraktikum5.R

class ChatAdapter (
    private val chatList: List<ChatModel>
): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.imageChat.setImageResource(chat.image)
        holder.nameChat.text = chat.name
        holder.pesanChat.text = chat.pesan
        holder.dateChat.text = chat.time
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageChat : de.hdodenhof.circleimageview.CircleImageView = itemView.findViewById((R.id.fotochat))
        val nameChat : TextView = itemView.findViewById((R.id.namachat))
        val pesanChat : TextView = itemView.findViewById((R.id.pesanchat))
        val dateChat : TextView = itemView.findViewById((R.id.waktuchat))
    }
}
