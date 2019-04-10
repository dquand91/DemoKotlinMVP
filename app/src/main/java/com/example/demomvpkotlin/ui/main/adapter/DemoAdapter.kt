package com.example.demomvpkotlin.ui.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.demomvpkotlin.R
import com.example.demomvpkotlin.customview.RecyclerItemListener
import com.example.demomvpkotlin.data.network.response.DataItem
import com.example.demomvpkotlin.utils.AppLogger
import kotlinx.android.synthetic.main.item_view.view.*
import java.util.ArrayList

class DemoAdapter(private val mContext : Context) : RecyclerView.Adapter<DemoAdapter.DemoViewHoler>() {

    private var mList: MutableList<DataItem> = ArrayList()

    fun updateList(list : List<DataItem>){
        AppLogger.debug("Updating List $list")
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    fun addList(list: List<DataItem>) {
        AppLogger.debug("Adding DataItem list items $list")
        mList.addAll(list)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DemoAdapter.DemoViewHoler {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.item_view, p0, false)
        return DemoViewHoler(itemView)
    }

    override fun getItemCount(): Int = mList.size


    override fun onBindViewHolder(holder: DemoViewHoler, position: Int) {

        val item = mList[position]

        holder.tvYear.text = item.year.toString()
        holder.tvName.text = item.name


    }


    inner class DemoViewHoler(view : View) : RecyclerView.ViewHolder(view){
        lateinit var tvName : TextView
        lateinit var tvYear : TextView

        init {
            tvName = view.findViewById(R.id.tvName)
            tvYear = view.findViewById(R.id.tvYear)
        }
    }

}