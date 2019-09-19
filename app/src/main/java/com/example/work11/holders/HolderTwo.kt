package com.example.dreamapplication.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work11.R

class HolderTwo(itemView: View) : RecyclerView.ViewHolder(itemView){

    var textTwo: TextView? = null

    init {
        textTwo = itemView.findViewById(R.id.item_2)
    }
}