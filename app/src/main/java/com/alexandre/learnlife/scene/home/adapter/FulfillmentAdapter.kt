package com.alexandre.learnlife.scene.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexandre.learnlife.R
import com.alexandre.learnlife.model.Fulfillment
import kotlinx.android.synthetic.main.fulfillment_item.view.*

class FulfillmentAdapter(private val fulfilments: ArrayList<Fulfillment>) : RecyclerView.Adapter<FulfillmentAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return fulfilments.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
                .inflate(R.layout.fulfillment_item, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.fulfillmentTitle.text = fulfilments[position].title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}