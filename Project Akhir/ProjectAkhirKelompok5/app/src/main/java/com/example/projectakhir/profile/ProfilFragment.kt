package com.example.projectakhir.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projectakhir.R
import com.example.projectakhir.data.AppDatabase
import com.example.projectakhir.data.entity.User
import com.example.projectakhir.first.LoginActivity
import com.example.projectakhir.helper.SharedPreference

class ProfilFragment : Fragment() {

    private lateinit var database: AppDatabase
    private lateinit var tampilnama: EditText
    private lateinit var tampilemail: EditText
    private lateinit var tampilpassword: EditText
    private lateinit var btnUbahProfil: Button
    private lateinit var sPH: SharedPreference

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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profil, container, false)

        tampilnama = view.findViewById(R.id.tampilnama)
        tampilemail = view.findViewById(R.id.tampilemail)
        tampilpassword = view.findViewById(R.id.tampilpassword)
        btnUbahProfil = view.findViewById(R.id.btn_ubahprofil)
        //tampiltxt.setText(value)
        sPH = SharedPreference(requireActivity())
        val dataku = sPH.getDataLogin()

        //val emails = arguments?.getString("email")
        val user = database.userDao().getUser(dataku)
        tampilemail.isFocusable = false
        tampilemail.isFocusableInTouchMode = false
        val nama = user.nama
        val email = user.email
        val password = user.password
        tampilnama.setText(nama)
        tampilemail.setText(email)
        //tampilpaspasswordsword.setText()

        tampilemail.isFocusable = false
        tampilemail.isFocusableInTouchMode = false

        btnUbahProfil.setOnClickListener{
            if (tampilnama.text.isNotEmpty() && tampilemail.text.isNotEmpty()){
                if(tampilpassword.text.isEmpty()){
                    database.userDao().update(
                        User(
                            email,
                            tampilnama.text.toString(),
                            password
                        )
                    )
                    Toast.makeText(
                        requireContext(),
                        "Profil Berhasil Diperbaharui!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }else{
                    if(tampilpassword.text.toString() != password){
                        database.userDao().update(
                            User(
                                email,
                                tampilnama.text.toString(),
                                tampilpassword.text.toString()
                            )
                        )
                        Toast.makeText(
                            requireContext(),
                            "Profil Berhasil Diperbaharui!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                        tampilpassword.setText("")
                    }else{
                        Toast.makeText(
                            requireContext(),
                            "Password Baru Tidak Boleh Sama Dengan Password Lama",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }else{
                Toast.makeText(
                    requireContext(),
                    "Silahkan isi semua data dengan valid!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

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