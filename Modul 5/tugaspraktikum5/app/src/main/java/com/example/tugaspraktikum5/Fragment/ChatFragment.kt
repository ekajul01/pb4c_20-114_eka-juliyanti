package com.example.tugaspraktikum5.Fragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikum5.Adapter.ChatAdapter
import com.example.tugaspraktikum5.Data.ChatModel
import com.example.tugaspraktikum5.R

class ChatFragment : Fragment() {

    lateinit var rvChat : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.bersih).isVisible = false
        menu.findItem(R.id.privasi).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        val lm = LinearLayoutManager(context)
        lm.orientation = LinearLayoutManager.VERTICAL
        rvChat = view.findViewById(R.id.recycler_view_chat)

        val adapterChat = ChatAdapter(ArrayChat)
        rvChat.setHasFixedSize(true)
        rvChat.layoutManager = lm
        rvChat.adapter = adapterChat

        return view
    }

    val ArrayChat : ArrayList<ChatModel>get(){
        val arraychat = ArrayList<ChatModel>()

        val listchat1 = ChatModel(R.drawable.upin, "Upin", "Halo, Apa kabar?", "10.05")
        val listchat2 = ChatModel(R.drawable.ipin, "Ipin", "Info posisi?", "09.10")
        val listchat3 = ChatModel(R.drawable.ehsan, "Mei-Mei", "Ayo nonton ges", "08.54")
        val listchat4 = ChatModel(R.drawable.upin, "Susanti", "Hmmm", "09.00")
        val listchat5 = ChatModel(R.drawable.ipin, "Fizi", "ppp", "07.08")
        val listchat6 = ChatModel(R.drawable.ehsan, "Mail", "Gass ae ta?", "Kemarin")
        val listchat7 = ChatModel(R.drawable.upin, "Ehsan", "Bakso enak ngene iki", "Kemarin")
        val listchat8 = ChatModel(R.drawable.ipin, "Jarjit", "info?", "Kemarin")
        val listchat9 = ChatModel(R.drawable.ehsan, "Mail", "Gass ae ta?", "Kemarin")
        val listchat10 = ChatModel(R.drawable.upin, "Ehsan", "Bakso enak ngene iki", "Kemarin")
        val listchat11 = ChatModel(R.drawable.ipin, "Jarjit", "info?", "Kemarin")
        val listchat12 = ChatModel(R.drawable.ipin, "Jarjit", "info?", "Kemarin")

        arraychat.add(listchat1)
        arraychat.add(listchat2)
        arraychat.add(listchat3)
        arraychat.add(listchat4)
        arraychat.add(listchat5)
        arraychat.add(listchat6)
        arraychat.add(listchat7)
        arraychat.add(listchat8)

        return arraychat
    }

}