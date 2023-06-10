
package com.example.projectakhir.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.R
import com.example.projectakhir.data.AppDatabase
import com.example.projectakhir.data.entity.Kriteria
import com.example.projectakhir.helper.SharedPreference

class DaftarKriteriaFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var database: AppDatabase
    private lateinit var dataList: MutableList<Kriteria>
    private lateinit var adapterKriteria: KriteriaAdapter
    private lateinit var sPH: SharedPreference

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = AppDatabase.getInstance(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daftar_kriteria, container, false)

        dataList = mutableListOf()
        adapterKriteria = KriteriaAdapter(dataList)
        sPH = SharedPreference(requireActivity())

        val dataDao = database.kriteriaDao()  // appDatabase adalah instance dari Room Database
        val dataList = dataDao.getAllKriteria()

        val lm = LinearLayoutManager(context)
        lm.orientation = LinearLayoutManager.VERTICAL
        recyclerView = view.findViewById(R.id.recycler_view_daftarkriteria)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = lm
        recyclerView.adapter = adapterKriteria

        adapterKriteria.setDialog(object : KriteriaAdapter.Dialog{
            override fun onClick(position: Int) {
                // membuat dialog view
                val dialog = AlertDialog.Builder(requireContext())
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener { dialog, which ->
                    if (which==0){
                        // coding hapus
                        database.kriteriaDao().deleteKriteria(dataList[position])
                        Toast.makeText(
                            requireContext(),
                            "Data berhasil dihapus!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                        getData()
                    }else{
                        // coding batal
                        dialog.dismiss()
                    }
                })
                // menampilkan dialog
                val dialogView = dialog.create()
                dialogView.show()
            }
        })

        return view
    }
    override fun onResume() {
        super.onResume()
        getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        dataList.clear()
        dataList.addAll(database.kriteriaDao().getAllKriteria())
        adapterKriteria.notifyDataSetChanged()
    }
}