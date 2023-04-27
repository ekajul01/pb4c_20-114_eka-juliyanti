package com.example.tugaspraktikum21
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var memberList: ArrayList<Member>
    private lateinit var memberAdapter: MemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        memberList = ArrayList()

        memberList.add(Member(R.drawable.treasure1, "Choi Hyunsuk", "Leader, Main Rapper, Lead Dancer"))
        memberList.add(Member(R.drawable.treasure2, "Park Jihoon", "Leader, Lead Vocal, Main Dancer"))
        memberList.add(Member(R.drawable.treasure3, "Yoshi", "Lead Rapper, Lead Dancer"))
        memberList.add(Member(R.drawable.treasure4, "Kim Junkyu", "Lead Vocal, Visual"))
        memberList.add(Member(R.drawable.treasure5, "Mashiho", "Visual, Lead Vocal, Main Dancer"))
        memberList.add(Member(R.drawable.treasure6, "Yoon Jaehyuk", "Sub Rapper, Sub Vocal"))
        memberList.add(Member(R.drawable.treasure7, "Asahi", "Lead Vocal, Visual"))
        memberList.add(Member(R.drawable.treasure8, "Bang Yedam", "Main Vocal"))
        memberList.add(Member(R.drawable.treasure9, "Kim Doyoung", "Main Dancer, Sub Vocal"))
        memberList.add(Member(R.drawable.treasure10, "Haruto", "Lead Rapper, Visual"))
        memberList.add(Member(R.drawable.treasure11, "Park Jeongwoo", "Main Vocal"))
        memberList.add(Member(R.drawable.treasure12, "So Junghwan", "Sub Vocal, Lead Dancer, Maknae"))

        memberAdapter = MemberAdapter(memberList)
        recyclerView.adapter = memberAdapter

        memberAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("member", it)

            startActivity(intent)
        }
    }
}