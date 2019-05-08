package com.smu.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var FoodList = arrayListOf<Food>(
        Food("1","canada"),
        Food("2","canada2"),
        Food("","d"),
        Food("1","canada"),
        Food("2","canada2"),
        Food("","d"),
        Food("1","canada"),
        Food("2","canada2"),
        Food("","d")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mAdapter = FoodRvAdapter(this,FoodList)
        recyclerView.adapter = mAdapter

        //Linear layout을 사용할 것 이다.
        val lm = LinearLayoutManager(this)
        recyclerView.layoutManager = lm

        recyclerView.setHasFixedSize(true)  // 안에 들어가는 네모의 크기를 고정해주겠다.
    }
}
