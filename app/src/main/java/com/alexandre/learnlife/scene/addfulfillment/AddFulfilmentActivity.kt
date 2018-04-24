package com.alexandre.learnlife.scene.addfulfillment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alexandre.learnlife.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_fulfilment.*

class AddFulfilmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fulfilment)

        sendBtn.setOnClickListener{
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("fulfilments")

            myRef.setValue(editText.text.toString())


        }
    }
}