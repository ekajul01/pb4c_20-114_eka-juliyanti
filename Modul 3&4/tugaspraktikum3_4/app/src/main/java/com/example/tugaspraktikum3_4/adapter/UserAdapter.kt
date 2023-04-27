package com.example.tugaspraktikum3_4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikum3_4.R
import com.example.tugaspraktikum3_4.data.dao.UserDao
import com.example.tugaspraktikum3_4.data.entity.User

class UserAdapter(var list:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var  dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }

    interface Dialog{
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var nim : TextView
        var fullName : TextView
        var email : TextView
        init {
            nim = view.findViewById(R.id.nim)
            fullName = view.findViewById(R.id.full_name)
            email = view.findViewById(R.id.email)
            view.setOnClickListener {
                dialog.onClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nim.text = list[position].nim
        holder.fullName.text = list[position].fullName
        holder.email.text = list[position].email
    }
}