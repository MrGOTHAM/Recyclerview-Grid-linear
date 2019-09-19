package com.example.dreamapplication.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work11.R

class HolderThree(itemView: View) : RecyclerView.ViewHolder(itemView){

    var textThree: TextView? = null

    init {
        textThree = itemView.findViewById(R.id.item_3)
    }
}