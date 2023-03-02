package com.example.recyclerview



class Test {
    private lateinit var todoList:MutableList<TaskToDo>
    private lateinit var task:TaskToDo
    private lateinit var completedTasks:MutableList<TaskToDo>
    fun checkTaskStatus(){
        todoList= mutableListOf()
        completedTasks= mutableListOf<TaskToDo>()
        todoList.add(TaskToDo("Learn python",false))
        todoList.add(TaskToDo("Learn java",true))
        todoList.add(TaskToDo("Learn kotlin",false))
        todoList.add(TaskToDo("Learn android",false))
        val listIterator=todoList.listIterator()
        for(i in todoList){
            if(i.isChecked){
                completedTasks.add(i)
            }
        }
        for(i in completedTasks){
            if(i in todoList){
                todoList.remove(i)
            }
        }
        println(todoList)
    }

}
fun main(){
    val test=Test()
    test.checkTaskStatus()

}