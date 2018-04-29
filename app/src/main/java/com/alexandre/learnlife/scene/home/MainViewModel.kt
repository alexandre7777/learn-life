package com.alexandre.learnlife.scene.home

import android.arch.lifecycle.ViewModel
import com.alexandre.learnlife.model.Fulfillment
import com.alexandre.learnlife.scene.home.adapter.FulfillmentAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainViewModel : ViewModel () {


    public fun getAllFilfilments (): ArrayList<Fulfillment> {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("fulfilments")



        val fulfilmentsArray = ArrayList<Fulfillment>()

        myRef.addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        //Get map of users in datasnapshot
                        val fulfilments : Map<String, String> = dataSnapshot.value as Map<String, String>


                        for ((fulfilment, count) in fulfilments) {

                            fulfilmentsArray.add(Fulfillment(fulfilment, count))
                        }

                        //adapter = FulfillmentAdapter(fulfilmentsArray)
                        //recyclerView.adapter = adapter
                    }
                    override fun onCancelled(databaseError: DatabaseError) {
                        //handle databaseError
                    }
                })
        return fulfilmentsArray
    }

}