package com.bilol.mytodoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.bilol.mytodoapp.R
import kotlinx.android.synthetic.main.item_group.view.*

class ExpandAdapter(var titList: List<String>, var map: HashMap<String, ArrayList<String>>) :
    BaseExpandableListAdapter() {

    override fun getGroupCount(): Int = titList.size

    override fun getChildrenCount(p0: Int): Int = map[titList[p0]]!!.size

    override fun getGroup(p0: Int): String = titList[p0]

    override fun getChild(p0: Int, p1: Int): Any {
        return map[titList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long = p0.toLong()

    override fun getChildId(p0: Int, p1: Int): Long = p1.toLong()

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val groupItemView: View
        if (p2 == null) {
            groupItemView = LayoutInflater.from(p3?.context).inflate(R.layout.item_group, p3, false)
        } else {
            groupItemView = p2
        }
        groupItemView.text_name.text = titList[p0]
        return groupItemView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var childItemView:View
        if (p3==null){
            childItemView = LayoutInflater.from(p4?.context).inflate(R.layout.child_group,p4,false)
        }else{
            childItemView = p3
        }
        val list = map[titList[p0]]
        val childItem = list?.get(p1)
        childItemView.text_name.text = childItem

        return childItemView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}







