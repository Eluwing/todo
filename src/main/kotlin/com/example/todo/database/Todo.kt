package com.example.todo.database

import java.time.LocalDateTime

data class Todo(
  var index:Int?=null,                // todo record index
  var title:String?=null,             // todo title
  var description:String?=null,       // todo contents
  var schedule: LocalDateTime?=null,  // todo schedule time
  var createdAt: LocalDateTime?=null, // create todo record time 
  var updatedAt: LocalDateTime?=null  // create todo update time
){

}
