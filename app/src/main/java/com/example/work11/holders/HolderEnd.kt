package com.example.dreamapplication.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work11.R

class HolderEnd(itemView: View) : RecyclerView.ViewHolder(itemView){

    var textEnd: TextView? = null

    init {
        textEnd = itemView.findViewById(R.id.item_end)
    }
}