package com.alexandre.learnlife.scene.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alexandre.learnlife.R
import com.alexandre.learnlife.model.Fulfillment
import com.alexandre.learnlife.scene.home.adapter.FulfillmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: FulfillmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = FulfillmentAdapter(createFakeFulfilments())
        recyclerView.adapter = adapter
    }


    fun createFakeFulfilments(): ArrayList<Fulfillment> {
        val fulfilments = ArrayList<Fulfillment>()

        fulfilments.add(Fulfillment(1, "Say hi to a stranger"))
        fulfilments.add(Fulfillment(2, "Do one commit on your repo"))
        fulfilments.add(Fulfillment(3, "Start working imediately after you wake up"))
        fulfilments.add(Fulfillment(4, "Smile !"))
        fulfilments.add(Fulfillment(5, "Learn one thing"))

        return fulfilments
    }
}
