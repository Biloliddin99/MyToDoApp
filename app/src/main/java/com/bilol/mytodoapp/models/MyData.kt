package com.bilol.mytodoapp.models

import com.bilol.mytodoapp.R

object MyData {
    lateinit var userArray:ArrayList<User>

    lateinit var map: HashMap<String,ArrayList<String>>
    lateinit var titleList: ArrayList<String>
    lateinit var openArray:ArrayList<String>
    lateinit var developmentArray:ArrayList<String>
    lateinit var uploadingArray:ArrayList<String>
    lateinit var rejectArray:ArrayList<String>
    lateinit var closedArray:ArrayList<String>

    fun loadData(){
        userArray = ArrayList()
        userArray.add(User(-1,"To do degree"))
        userArray.add(User(R.drawable.redflag,"Urgent"))
        userArray.add(User(R.drawable.yellowflag,"High"))
        userArray.add(User(R.drawable.blueflag,"Normal"))
        userArray.add(User(R.drawable.greyflag,"Low"))
    }

    fun fromCechToArray(){
        map = HashMap()
        titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Close")

        openArray = ArrayList()
        developmentArray = ArrayList()
        uploadingArray = ArrayList()
        rejectArray = ArrayList()
        closedArray = ArrayList()

    }
}