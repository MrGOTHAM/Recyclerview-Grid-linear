package com.example.work11.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dreamapplication.holders.*
import com.example.work11.MainActivity.Companion.TYPE_1
import com.example.work11.MainActivity.Companion.TYPE_2
import com.example.work11.MainActivity.Companion.TYPE_3
import com.example.work11.MainActivity.Companion.TYPE_4
import com.example.work11.R

class RecyclerViewAdapter : BaseRecyclers() {




    override fun getData(dataList: ArrayList<MutableMap<Int, String>>) {
        setData(dataList)
    }

    override fun getHeader(head: String) {
        setHeader(head)
    }

    override fun getEnd(end: String) {
        setEnd(end)
    }


    var iViewInterface: IViewInterface? = null


    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null
        return when (viewType) {
            HEADER -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_header, parent, false)
                HolderHeader(view!!)
            }
            END -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_end, parent, false)
                HolderEnd(view!!)
            }

            ITEM__1 -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_1, parent, false)
                HolderOne(view!!)
            }
            ITEM__2 -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_2, parent, false)
                HolderTwo(view!!)
            }
            ITEM__3 -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_3, parent, false)
                HolderThree(view!!)
            }
            else -> {
                HolderThree(view!!)

            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i(TAG, "执行次数$position")
        when {
            position < mHeader.size && needHeader -> (holder as HolderHeader).textHeader?.text = mHeader[position]

            position == itemCount - mEnd.size -> (holder as HolderEnd).textEnd?.text = mEnd[0]

            mDataList[myPosition][TYPE_1] == "third" -> (holder as HolderThree).textThree?.text =
                mDataList[myPosition][TYPE_2]
            mDataList[myPosition][TYPE_1] == "first" -> {
                (holder as HolderOne).textOne?.text = mDataList[myPosition][TYPE_2]
                holder.textTwo?.text = mDataList[myPosition][TYPE_3]
                holder.textThree?.text = mDataList[myPosition][TYPE_4]

            }
            mDataList[myPosition][TYPE_1] == "second" -> (holder as HolderTwo).textTwo?.text =
                mDataList[myPosition][TYPE_2]
        }
        if (myPosition >= 0 && myPosition < mDataList.size && needHeader) {
            holder.itemView.setOnClickListener {

                iItemClickListener!!.onItemClickListener(position - mHeader.size)

            }
        } else if (!needHeader && myPosition < mDataList.size) {
            holder.itemView.setOnClickListener {
                iItemClickListener!!.onItemClickListener(position)
            }
        }
    }
}