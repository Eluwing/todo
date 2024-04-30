package com.example.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController{
  @GetMapping
  fun index(): String{
    println("Hi User")
    return "Hello kotiln Spring"
  }

  @GetMapping("/Hi")
  fun test(): String{
    return "Test"
  }
}