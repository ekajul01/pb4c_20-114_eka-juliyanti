package com.example.tugaspraktikum21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val member = intent.getParcelableExtra<Member>("member")
        if (member != null){
            val textView : TextView = findViewById(R.id.detailActivityTV)
            val imageView : ImageView = findViewById(R.id.detailActivityIV)
            val textView2 : TextView = findViewById(R.id.deskripsi)

            textView.text = member.name
            imageView.setImageResource(member.image)
            textView2.text = member.deskripsi
        }
    }
}
