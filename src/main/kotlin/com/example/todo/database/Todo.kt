package com.example.todo.database

import java.time.LocalDateTime
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.example.todo.model.http.TodoDto

data class Todo(
  var index:Int?=null,                // todo record index
  var title:String?=null,             // todo title
  var description:String?=null,       // todo contents
  var schedule: LocalDateTime?=null,  // todo schedule time
  var createdAt: LocalDateTime?=null, // create todo record time 
  var updatedAt: LocalDateTime?=null  // create todo update time
){

}

fun Todo.convertTodo(todoDto:TodoDto): Todo{
  return Todo().apply { 
    this.index = todoDto.index
    this.title = todoDto.title
    this.description = todoDto.description
    this.schedule = LocalDateTime.parse(todoDto.schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    this.createdAt = todoDto.createdAt
    this.updatedAt = todoDto.updatedAt
  }
}
