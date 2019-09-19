package com.example.work11.adapters


interface IViewInterface {
    fun getData(dataList:ArrayList<MutableMap<Int, String>>)

    fun getHeader(head:String)

    fun getEnd(end:String)
}