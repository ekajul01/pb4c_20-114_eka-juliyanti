package com.example.tugaspraktikum21
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
class MemberAdapter(private val memberList:ArrayList<Member>)
    : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>(){
    var onItemClick : ((Member) -> Unit)? = null
    class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageMember : ImageView = itemView.findViewById(R.id.imageMember)
        val textName : TextView = itemView.findViewById(R.id.textName)
        val textDeskripsi : TextView = itemView.findViewById(R.id.textDescription)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_member, parent, false)
        return MemberViewHolder(view)
    }
    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val member = memberList[position]
        holder.imageMember.setImageResource(member.image)
        holder.textName.text = member.name
        holder.textDeskripsi.text = member.deskripsi

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(member)
        }
    }
}
