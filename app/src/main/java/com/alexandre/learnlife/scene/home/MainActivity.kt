package com.alexandre.learnlife.scene.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.alexandre.learnlife.R
import com.alexandre.learnlife.model.Fulfillment
import com.alexandre.learnlife.scene.addfulfillment.AddFulfilmentActivity
import com.alexandre.learnlife.scene.home.adapter.FulfillmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener





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

        btnGotoAdd.setOnClickListener{
            val intent = Intent(this, AddFulfilmentActivity::class.java)
            startActivity(intent)
        }


        //TODO read list from Firebase database
        /*
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("TAG", "Value is: " + value!!)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })*/
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
