package com.example.work11.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.work11.MainActivity

abstract class BaseRecyclers : RecyclerView.Adapter<RecyclerView.ViewHolder>(),IViewInterface {
    companion object {
        const val ITEM__1 = 0
        const val ITEM__2 = 1
        const val ITEM__3 = 3
        const val HEADER = -1
        const val END = -2
        const val TAG = "this"
    }



    var mContext: Context? = null

    var needHeader: Boolean = true
    var myPosition = 0

    var iItemClickListener: IItemClickListener? = null


    var mDataList = arrayListOf(mutableMapOf<Int, String>())
    var mHeader: ArrayList<String> = arrayListOf()
    var mEnd: ArrayList<String> = arrayListOf()





    override fun getItemCount(): Int {
        return if (needHeader) {
            mDataList.size + mHeader.size + mEnd.size
        } else {
            mDataList.size + mEnd.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (needHeader) {
            myPosition = position - mHeader.size
        } else if (!needHeader) {
            myPosition = position
        }

        if (myPosition < 0) {
            return HEADER
        } else if (position == itemCount - 1) {
            return END
        }
        return when {
            mDataList[myPosition][MainActivity.TYPE_1] == "second" -> ITEM__2
            mDataList[myPosition][MainActivity.TYPE_1] == "third" -> ITEM__3
            mDataList[myPosition][MainActivity.TYPE_1] == "first" -> ITEM__1
            else -> -10
        }
    }

    fun setHeader(headerName: String) {
        mHeader.clear()
        mHeader.add("新加的头")
        mHeader.add(headerName)
        notifyDataSetChanged()
    }

    fun setData(dataList: ArrayList<MutableMap<Int, String>>) {
        mDataList.clear()
        this.mDataList = dataList
        notifyDataSetChanged()
    }

    fun setEnd(end: String) {
        mEnd.clear()
        mEnd.add(end)
        notifyDataSetChanged()
    }

    fun giveAContext(context: Context) {
        this.mContext = context
    }

    fun setOnKotlinItemClickListener(iItemClickListener: IItemClickListener) {
        this.iItemClickListener = iItemClickListener
    }
    fun changeToNoHead(){
        if (needHeader){
            needHeader = false
        }else{
            needHeader = true
        }
        notifyDataSetChanged()
    }
}