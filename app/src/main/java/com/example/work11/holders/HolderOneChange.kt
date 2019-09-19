package com.example.work11.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work11.R

class HolderOneChange(itemView: View) : RecyclerView.ViewHolder(itemView){

    var textOne: TextView? = null
    var textTwo: TextView? = null
    var textThree: TextView? = null

    init {
        textOne = itemView.findViewById(R.id.item_1_change)
        textTwo = itemView.findViewById(R.id.item_2_change)
        textThree = itemView.findViewById(R.id.item_3_change)



    }
}