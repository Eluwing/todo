package com.example.todo.model.http

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.hibernate.validator.constraints.NotBlank
import jakarta.validation.constraints.AssertTrue

data class TodoDto(
  var index:Int?=null,
  
  @field:NotBlank
  var title:String?=null,

  var description:String?=null,
  
  @field:NotBlank
  // yyyy-MM-dd HH:mm:ss
  var schedule:String?=null,
  var createdAt:LocalDateTime?=null,
  var updatedAt:LocalDateTime?=null
){
  @AssertTrue(message = "Not in valid Date format(yyyy-MM-dd HH:mm:ss)")
  fun validSchedule(): Boolean{
    return try{
      LocalDateTime.parse(schedule,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
      true
    }catch (e:Exception){
      false
    }
  }
}