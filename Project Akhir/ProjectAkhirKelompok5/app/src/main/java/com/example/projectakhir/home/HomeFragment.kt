package com.example.projectakhir.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.projectakhir.R
import com.example.projectakhir.data.AppDatabase
import com.example.projectakhir.first.LoginActivity
import com.example.projectakhir.helper.SharedPreference
import com.google.android.material.tabs.TabLayout

class HomeFragment() : Fragment() {

    //private lateinit var tampiltxt: TextView
    private lateinit var database: AppDatabase
    private lateinit var sPH: SharedPreference
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = AppDatabase.getInstance(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.action_menu, menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        sPH = SharedPreference(requireActivity())
        //tampiltxt = view.findViewById(R.id.tampil_home)

        tabLayout = view.findViewById(R.id.tablayout)
        viewPager = view.findViewById(R.id.viewPager)

        viewPager.adapter = FragmentAdapter(childFragmentManager) // Ganti dengan adapter kustom Anda sendiri
        tabLayout.setupWithViewPager(viewPager)

        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                // Tambahkan tindakan logout di sini
                sPH.setStatusLogin(false)
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(activity, "Anda berhasil logout", Toast.LENGTH_SHORT).show()
                activity?.finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}