package com.example.work11

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.work11.adapters.GridViewAdapter
import com.example.work11.adapters.IItemClickListener
import com.example.work11.adapters.IViewInterface
import com.example.work11.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TYPE_1 = 1
        const val TYPE_2 = 2
        const val TYPE_3 = 3
        const val TYPE_4 = 4
        const val TYPE_5 = 5
    }

    private var map = mutableMapOf<Int, String>()
    var mData = arrayListOf(mutableMapOf<Int, String>())
    var linearAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    var gridViewAdapter: GridViewAdapter = GridViewAdapter()
    var changeView: Boolean = false

    private var mRecyclerHandlerImpl:RecyclerHandlerImpl?= null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
        mRecyclerHandlerImpl= RecyclerHandlerImpl(linearAdapter,gridViewAdapter)
        setDatas()
    }

    @SuppressLint("WrongConstant")
    fun initView() {
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list_view.layoutManager = manager
        list_view.adapter = linearAdapter
        linearAdapter.giveAContext(this)

        change_data.setOnClickListener {
            mRecyclerHandlerImpl?.getHeader("改完的head")
        }
        if_hide_header.setOnClickListener {
                        linearAdapter.changeToNoHead()
        }
        if_change_view.setOnClickListener {
            if (changeView) {
                changeView = false
                initData()
                val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                list_view.layoutManager = manager
                list_view.adapter = linearAdapter
                linearAdapter.giveAContext(this)
                linearAdapter.setOnKotlinItemClickListener(object : IItemClickListener {
                    override fun onItemClickListener(position: Int) {

                        Toast.makeText(applicationContext, mData[position][TYPE_5].toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            } else {
                changeView = true
                initData()
                val manager = GridLayoutManager(this, 3)
                list_view.layoutManager = manager
                list_view.adapter = gridViewAdapter

                gridViewAdapter.giveAContext(this)
                gridViewAdapter.setOnKotlinItemClickListener(object : IItemClickListener {
                    override fun onItemClickListener(position: Int) {

                        Toast.makeText(applicationContext, mData[position][TYPE_5].toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            }
        }
        linearAdapter.setOnKotlinItemClickListener(object : IItemClickListener {
            override fun onItemClickListener(position: Int) {

                Toast.makeText(applicationContext, mData[position][TYPE_5].toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initData() {
        mData.clear()
        for (i in 0..50) {
            map = mutableMapOf()
            map[TYPE_1] = "first"
            map[TYPE_2] = "安 ${i + 1}"
            map[TYPE_3] = "超 ${i + 1}"
            map[TYPE_4] = "广 ${i + 1}"
            map[TYPE_5] = "模块 ${i + 1}"
            mData.add(map)
        }
        Log.i("ancg", mData.toString())
    }
    private fun setDatas(){
        mRecyclerHandlerImpl?.getData(mData)
        mRecyclerHandlerImpl?.getEnd("我是表尾。。。")
        mRecyclerHandlerImpl?.getHeader("我是表头")
    }
}