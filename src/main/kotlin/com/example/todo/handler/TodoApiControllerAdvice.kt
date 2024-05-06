package com.example.todo.handler

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.validation.FieldError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import jakarta.servlet.http.HttpServletRequest
import kotlin.require
import java.time.LocalDateTime
import com.example.todo.model.http.ErrorResponse

class TodoApiControllerAdvice{
  
  @ExceptionHandler(MethodArgumentNotValidException::class)
  fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse>{
    val errors = mutableListOf<com.example.todo.model.http.Error>()

    e.bindingResult.allErrors.forEach { errorObj ->

      com.example.todo.model.http.Error().apply{
        this.field = (errorObj as FieldError).field
        this.message = errorObj.defaultMessage
        this.value = errorObj.rejectedValue
      }.apply{
        errors.add(this)
      }
    }
    val errorResponse = ErrorResponse().apply{
      this.resultCode = "FAIL"
      this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
      this.httpMethod = request.method
      this.message = ""
      this.path = request.requestURI
      this.timeStamp = LocalDateTime.now()
      this.errors = errors
    }
    
    return ResponseEntity.badRequest().body(errorResponse)
  }
}