package com.bilol.mytodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bilol.mytodoapp.databinding.ActivityTodo3Binding
import com.bilol.mytodoapp.models.MySharedPreference
import com.bilol.mytodoapp.models.MyToDoPlan

class Todo3 : AppCompatActivity() {
    private lateinit var binding: ActivityTodo3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodo3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        val name = intent.getStringExtra("name")
        val plaArray = MySharedPreference.obektString
        var plan1 = MyToDoPlan()
        var index = -1
        for (plan in plaArray){
            if (plan.name == name){
                plan1 = plan
                index = plaArray.indexOf(plan)
                binding.textTodo1.text = plan.name
                binding.createText.text = plan.createData
                binding.deadlineText.text = plan.dedline
                binding.txtDegree.text = plan.degree!!.name
                when(plan.level){
                    "Open" -> binding.radOpen.isChecked = true
                    "Development" -> binding.radOpen.isChecked = true
                    "Uploading" -> binding.radOpen.isChecked = true
                    "Reject" -> binding.radOpen.isChecked = true
                    "Close" -> binding.radOpen.isChecked = true
                }
                break
            }
        }
        binding.btnOk.setOnClickListener {
            var rad = ""
            if (binding.radOpen.isChecked) rad="Open"
            if (binding.radClosed.isChecked) rad="Close"
            if (binding.radDev.isChecked) rad="Development"
            if (binding.radReject.isChecked) rad="Reject"
            if (binding.radUploading.isChecked) rad="Close"

            plan1.level = rad
            plaArray[index] = plan1
            MySharedPreference.obektString = plaArray
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}