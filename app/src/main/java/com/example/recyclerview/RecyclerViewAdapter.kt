package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*

class RecyclerViewAdapter(private val toDoList:MutableList<TaskToDo>):RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(taskView: View):RecyclerView.ViewHolder(taskView){

    }

    //when we scroll a new item is visible
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return MyViewHolder(view)
    }
    //returns how many items in the recycler view
    override fun getItemCount(): Int {
        return toDoList.size
    }
    // bind the data to the item and set it to the corresponding view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            task.text= toDoList[position].title
            checkBox.isChecked=toDoList[position].isChecked
        }
    }


}
