package com.example.todo.model.http

import java.time.LocalDateTime
import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorResponse(
  @JsonProperty("result_code")
  var resultCode:String?=null,

  @JsonProperty("https_status")
  var httpStatus:String?=null,

  @JsonProperty("https_method")
  var httpMethod:String?=null,
  var message:String?=null,
  var path:String?=null,

  @JsonProperty("time_stamp")
  var timeStamp:LocalDateTime?=null,
  var errors:MutableList<Error>?=null

){
}

data class Error(
  var field:String?=null,
  var message:String?=null,
  var value:Any?=null
){
}