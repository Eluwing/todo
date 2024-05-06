package com.example.todo.model.http

import jakarta.validation.Validation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TodoDtoTest {

  val validator = Validation.buildDefaultValidatorFactory().validator

  @Test
  fun todoDtoTest(){
    val todoDto = TodoDto().apply{
      this.title = "테스트"
      this.description = ""
      this.schedule = "2024-04-30 20:00:00"
    }

    val result = validator.validate(todoDto)

    Assertions.assertEquals(true,result.isEmpty())
  }

}