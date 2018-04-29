package com.alexandre.learnlife.scene.home

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alexandre.learnlife.R
import com.alexandre.learnlife.scene.addfulfillment.AddFulfilmentActivity
import com.alexandre.learnlife.scene.home.adapter.FulfillmentAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: FulfillmentAdapter

    val mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        btnGotoAdd.setOnClickListener{
            val intent = Intent(this, AddFulfilmentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        adapter = FulfillmentAdapter(mViewModel.getAllFilfilments())
        recyclerView.adapter = adapter
    }
}
