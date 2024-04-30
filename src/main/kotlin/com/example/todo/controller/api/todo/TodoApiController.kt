package com.example.todo.controller.api.todo

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import com.example.todo.model.http.TodoDto
import jakarta.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController{
  
  @GetMapping(path = [""])
  fun read(@RequestParam(required = false) index:Int?){

  }

  @PostMapping(path = [""])
  fun create(@Valid @RequestBody todoDto: TodoDto){

  }

  @PutMapping(path = [""])
  fun update(@Valid @RequestBody todoDto: TodoDto){

  }

  @DeleteMapping(path = ["/{index}"])
  fun delete(@PathVariable(name = "index") _index: Int){

  }
}
