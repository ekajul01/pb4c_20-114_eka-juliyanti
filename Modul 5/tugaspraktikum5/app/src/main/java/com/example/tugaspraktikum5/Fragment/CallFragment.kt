package com.example.tugaspraktikum5.Fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikum5.Adapter.CallAdapter
import com.example.tugaspraktikum5.Data.CallModel
import com.example.tugaspraktikum5.R

class CallFragment : Fragment() {

    lateinit var rvCall : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.privasi).isVisible = false
        menu.findItem(R.id.grup_baru).isVisible = false
        menu.findItem(R.id.siaran_baru).isVisible = false
        menu.findItem(R.id.perangkat).isVisible = false
        menu.findItem(R.id.pesan).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_call, container, false)
        val lm = LinearLayoutManager(context)
        lm.orientation = LinearLayoutManager.VERTICAL
        rvCall = view.findViewById(R.id.recycler_view_call)
        val adapterCall = CallAdapter(ArrayCall)
        rvCall.setHasFixedSize(true)
        rvCall.layoutManager = lm
        rvCall.adapter = adapterCall
        return view
    }

    val ArrayCall : ArrayList<CallModel>get(){
        val arraycall = ArrayList<CallModel>()

        val listcall1 = CallModel(R.drawable.upin, "Upin", R.drawable.call_made_green,
            "5 menit yang lalu", R.drawable.call)
        val listcall2 = CallModel(R.drawable.ipin, "Ipin",  R.drawable.call_made_red,
            "10 menit yang lalu", R.drawable.call)
        val listcall3 = CallModel(R.drawable.ehsan, "Ehsan",  R.drawable.call_received_red,
            "1 jam yang lalu", R.drawable.video)
        val listcall4 = CallModel(R.drawable.meimei, "Mei-Mei", R.drawable.call_made_green,
            "2 jam yang lalu", R.drawable.call)
        val listcall5 = CallModel(R.drawable.ehsan, "Ehsan",  R.drawable.call_made_red,
            "11 Mei 12.20", R.drawable.call)
        val listcall6 = CallModel(R.drawable.susanti, "Susanti",  R.drawable.call_received_green,
            "12 Mei 11.00", R.drawable.video)
        val listcall7 = CallModel(R.drawable.mail, "Mail", R.drawable.call_made_green,
            "12 Mei 09.10", R.drawable.video)
        val listcall8 = CallModel(R.drawable.jarjit, "Jarjir",  R.drawable.call_made_green,
            "13 Mei 22.21", R.drawable.call)
        val listcall9 = CallModel(R.drawable.fizi, "Fizi",  R.drawable.call_received_red,
            "13 Mei 15.42", R.drawable.video)
        val listcall10 = CallModel(R.drawable.fizi, "Fizi", R.drawable.call_made_green,
            "14 Mei 07.00", R.drawable.call)
        val listcall11 = CallModel(R.drawable.meimei, "Mei-Mei",  R.drawable.call_received_green,
            "15 Mei 14.45", R.drawable.call)
        val listcall12 = CallModel(R.drawable.susanti, "Susanti",  R.drawable.call_received_red,
            "15 Mei 06.23", R.drawable.video)

        arraycall.add(listcall1)
        arraycall.add(listcall2)
        arraycall.add(listcall3)
        arraycall.add(listcall4)
        arraycall.add(listcall5)
        arraycall.add(listcall6)
        arraycall.add(listcall7)
        arraycall.add(listcall8)
        arraycall.add(listcall9)
        arraycall.add(listcall10)
        arraycall.add(listcall11)
        arraycall.add(listcall12)

        return arraycall
    }

}