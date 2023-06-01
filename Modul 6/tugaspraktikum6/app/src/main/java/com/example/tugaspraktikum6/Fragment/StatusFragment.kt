package com.example.tugaspraktikum6.Fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikum6.Adapter.StatusAdapter
import com.example.tugaspraktikum6.Model.StatusModel
import com.example.tugaspraktikum6.R

class StatusFragment : Fragment() {

    lateinit var rvStatus : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.action_menu, menu)
        menu.findItem(R.id.bersih).isVisible = false
        menu.findItem(R.id.grup_baru).isVisible = false
        menu.findItem(R.id.siaran_baru).isVisible = false
        menu.findItem(R.id.perangkat).isVisible = false
        menu.findItem(R.id.pesan).isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_status, container, false)

        val lm = LinearLayoutManager(context)
        lm.orientation = LinearLayoutManager.VERTICAL
        rvStatus = view.findViewById(R.id.recycler_view_status)

        val adapterStatus = StatusAdapter(ArrayStatus)
        rvStatus.setHasFixedSize(true)
        rvStatus.layoutManager = lm
        rvStatus.adapter = adapterStatus

        return view
    }

    val ArrayStatus : ArrayList<StatusModel>get(){
        val arraystatus = ArrayList<StatusModel>()

        val liststatus1 = StatusModel(R.drawable.upin, "Upin", "Baru saja")
        val liststatus2 = StatusModel(R.drawable.ipin, "Ipin", "10 menit yang lalu")
        val liststatus3 = StatusModel(R.drawable.ehsan, "Ehsan", "32 menit yang lalu")
        val liststatus4 = StatusModel(R.drawable.meimei, "Mei-Mei", "hari ini 09.01")
        val liststatus5 = StatusModel(R.drawable.mail, "Mail", "Hari ini 07.59")
        val liststatus6 = StatusModel(R.drawable.jarjit, "Jarjit", "Hari ini 00.32")
        val liststatus7 = StatusModel(R.drawable.fizi, "Fizi", "Kemarin 23.23")
        val liststatus8 = StatusModel(R.drawable.susanti, "Susanti", "Kemarin 20.43")

        arraystatus.add(liststatus1)
        arraystatus.add(liststatus2)
        arraystatus.add(liststatus3)
        arraystatus.add(liststatus4)
        arraystatus.add(liststatus5)
        arraystatus.add(liststatus6)
        arraystatus.add(liststatus7)
        arraystatus.add(liststatus8)

        return arraystatus
    }

}