package com.example.projectakhir.tambahdata

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Fragment2Adapter (fm: FragmentManager) : FragmentPagerAdapter
    (fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // Return Fragment sesuai posisi tab
        return when (position) {
            0 -> DataWisataFragment()
            else -> DataKriteriaFragment()
        }
    }

    override fun getCount(): Int {
        // Jumlah tab
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Judul tab
        return when (position) {
            0 -> "Tambah Wisata"
            else -> "Tambah Kriteria"
        }
    }
}