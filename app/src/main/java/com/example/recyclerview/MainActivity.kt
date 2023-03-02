package com.example.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_task.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoList:MutableList<TaskToDo>
    private lateinit var task:String
    private lateinit var completedTask:MutableList<TaskToDo>
    private lateinit var adapter:RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addTask()
//        if(todoList.size>1) checkTaskStatus()

    }

    private fun addTask(){
        todoList= mutableListOf()
        adapter=RecyclerViewAdapter(todoList)
        recyclerView.adapter=adapter
        addTask.setOnClickListener {
            task=TaskToDo.text.toString()
            todoList.add(TaskToDo(task,false))
            adapter.notifyItemInserted(todoList.size-1)
        }

    }
    @SuppressLint("NotifyDataSetChanged")
    private fun checkTaskStatus(){
        completedTask= mutableListOf()
        for(i in todoList){
            if(i.isChecked){
                completedTask.add(i)
            }
        }
        for(i in completedTask){
            if(i in todoList){
                todoList.remove(i)
                adapter.notifyItemRemoved(todoList.indexOf(i))
            }
        }
    }

}