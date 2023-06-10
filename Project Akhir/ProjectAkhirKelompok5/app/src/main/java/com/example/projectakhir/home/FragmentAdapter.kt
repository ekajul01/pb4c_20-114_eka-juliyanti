package com.example.projectakhir.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter
    (fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // Return Fragment sesuai posisi tab
        return when (position) {
            0 -> DaftarWisataFragment()
            1 -> DaftarKriteriaFragment()
            else -> DaftarPerhitunganFragment()
        }
    }

    override fun getCount(): Int {
        // Jumlah tab
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Judul tab
        return when (position) {
            0 -> "Data Wisata"
            1 -> "Data Kriteria"
            else -> "Perhitungan"
        }
    }
}