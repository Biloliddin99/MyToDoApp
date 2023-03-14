package com.bilol.mytodoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bilol.mytodoapp.R
import com.bilol.mytodoapp.models.User
import kotlinx.android.synthetic.main.spinner_view.view.*

class MyAdapter1(val list: List<User>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val itemView:View
        if (p1==null){
            itemView = LayoutInflater.from(p2?.context).inflate(R.layout.spinner_view,p2,false)
        }else{
            itemView=p1
        }
        itemView.text_spinner.text = list[p0].name
        if (list[p0].image != -1)
            itemView.image.setImageResource(list[p0].image)

        return itemView
    }

}