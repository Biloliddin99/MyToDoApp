package com.bilol.mytodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bilol.mytodoapp.adapters.ExpandAdapter
import com.bilol.mytodoapp.databinding.ActivityMainBinding
import com.bilol.mytodoapp.databinding.ActivityTodoListBinding
import com.bilol.mytodoapp.models.MyData
import com.bilol.mytodoapp.models.MySharedPreference
import com.bilol.mytodoapp.models.MyToDoPlan

class TodoList : AppCompatActivity() {
    lateinit var titleList: ArrayList<String>
    lateinit var map: HashMap<String,ArrayList<String>>
    lateinit var openArray:ArrayList<String>
    lateinit var developmentArray:ArrayList<String>
    lateinit var uploadingArray:ArrayList<String>
    lateinit var rejectArray:ArrayList<String>
    lateinit var closedArray:ArrayList<String>

    private lateinit var binding: ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreference.init(this)
        toArray()

        binding.myExpandView.setOnChildClickListener { _, _, i, i2, _ ->
            val intent = Intent(this,Todo3::class.java)
            intent.putExtra("name",MyData.map[MyData.titleList[i]]?.get(i2))
            startActivity(intent)
            true
        }
    }

    private fun toArray() {
//        MyData.fromCechToArray()

        MyData.map = HashMap()
        MyData.titleList = ArrayList()
        MyData.titleList.add("Open")
        MyData.titleList.add("Development")
        MyData.titleList.add("Uploading")
        MyData.titleList.add("Reject")
        MyData.titleList.add("Close")

        MyData.openArray = ArrayList()
        MyData.developmentArray = ArrayList()
        MyData.uploadingArray = ArrayList()
        MyData.rejectArray = ArrayList()
        MyData.closedArray = ArrayList()

        var planArray = ArrayList<MyToDoPlan>()

        planArray = MySharedPreference.obektString
        val nameArray = ArrayList<MyToDoPlan>()
        for (todoPlan in planArray) {
            if (todoPlan.level == "Open") {
                MyData.openArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Development") {
                MyData.openArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Uploading") {
                MyData.openArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Reject") {
                MyData.openArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Close") {
                MyData.openArray.add(todoPlan.name)
            }
        }

        MyData.map[MyData.titleList[0]] = MyData.openArray
        MyData.map[MyData.titleList[1]] = MyData.developmentArray
        MyData.map[MyData.titleList[2]] = MyData.uploadingArray
        MyData.map[MyData.titleList[3]] = MyData.rejectArray
        MyData.map[MyData.titleList[4]] = MyData.closedArray
    }

    override fun onStart() {
        super.onStart()
        MySharedPreference.init(this)
        toArray()
        val spinnerAdapter1 = ExpandAdapter(MyData.titleList,MyData.map)
        binding.myExpandView.setAdapter(spinnerAdapter1)
    }
}