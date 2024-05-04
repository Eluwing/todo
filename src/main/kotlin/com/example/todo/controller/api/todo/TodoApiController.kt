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
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.HttpHeaders
import com.example.todo.model.http.TodoDto
import com.example.todo.service.TodoService
import jakarta.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController(
  val todoService: TodoService
){
  
  @GetMapping(path = [""])
  fun read(@RequestParam(required = false) index:Int?):ResponseEntity<Any?>{
    return index?.let{
      todoService.read(it)
    }?.let{
      ResponseEntity.ok(it)
    }?: kotlin.run{
      return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/api/todo/all").build()
    }
    
  }

  // @GetMapping(path = ["/all"])
  // fun readAll():MutableList<TodoDto>{
  //   return todoService.readAll()
  // }

  // @PostMapping(path = [""])
  // fun create(@Valid @RequestBody todoDto: TodoDto){

  // }

  // @PutMapping(path = [""])
  // fun update(@Valid @RequestBody todoDto: TodoDto){

  // }

  // @DeleteMapping(path = ["/{index}"])
  // fun delete(@PathVariable(name = "index") _index: Int){

  // }
}
