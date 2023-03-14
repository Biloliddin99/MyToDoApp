package com.bilol.mytodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SpinnerAdapter
import android.widget.Toast
import com.bilol.mytodoapp.adapters.MyAdapter1
import com.bilol.mytodoapp.databinding.ActivityAddTodoBinding
import com.bilol.mytodoapp.models.MyData
import com.bilol.mytodoapp.models.MySharedPreference
import com.bilol.mytodoapp.models.MyToDoPlan
import com.bilol.mytodoapp.models.User
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodo : AppCompatActivity() {
    private lateinit var binding: ActivityAddTodoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lateinit var userArray:ArrayList<User>
        MyData.loadData()

        val spinnerAdapter = MyAdapter1(MyData.userArray)
        binding.spinnerTodo.adapter = spinnerAdapter

        binding.btnSaveAddToDo.setOnClickListener {
            val toDoName = binding.editName.toString().trim()
            val toDoDescription = binding.editDescription.toString().trim()
            val toDoCreateData = binding.editCreateDate.toString().trim()
            val toDoDeadline = binding.editDeadline.toString().trim()

            val degree = userArray[binding.spinnerTodo.selectedItemPosition]

            if (toDoName.isNotEmpty()&&toDoDescription.isNotEmpty()&&toDoCreateData.isNotEmpty()&&toDoDeadline.isNotEmpty()){
                val myList = MySharedPreference.obektString
                myList.add(MyToDoPlan("Open",toDoName, toDoDescription, degree, toDoCreateData, toDoDeadline))
                MySharedPreference.obektString = myList
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "EditText is empty", Toast.LENGTH_SHORT).show()
            }
        }

    }
}