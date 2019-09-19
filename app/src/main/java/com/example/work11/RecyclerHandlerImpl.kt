package com.example.work11

import com.example.work11.adapters.GridViewAdapter
import com.example.work11.adapters.IViewInterface
import com.example.work11.adapters.RecyclerViewAdapter

class RecyclerHandlerImpl(recyclerViewAdapter: RecyclerViewAdapter, gridViewAdapter: GridViewAdapter) : IViewInterface {


    private var mRecyclerViewAdapter: RecyclerViewAdapter = recyclerViewAdapter
    private var mGridViewAdapter: GridViewAdapter = gridViewAdapter


    override fun getData(dataList: ArrayList<MutableMap<Int, String>>) {

        mRecyclerViewAdapter.getData(dataList)
        mGridViewAdapter.getData(dataList)
    }

    override fun getHeader(head: String) {
        mRecyclerViewAdapter.getHeader(head)
        mGridViewAdapter.getHeader(head)
    }

    override fun getEnd(end: String) {
        mRecyclerViewAdapter.getEnd(end)
        mGridViewAdapter.getEnd(end)
    }

}