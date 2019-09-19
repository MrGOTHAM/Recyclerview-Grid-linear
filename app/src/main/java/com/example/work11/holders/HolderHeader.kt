package com.example.dreamapplication.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work11.R

class HolderHeader(itemView:View) : RecyclerView.ViewHolder(itemView){

var textHeader:TextView? = null

init {
    textHeader = itemView.findViewById(R.id.item_header)
}
}