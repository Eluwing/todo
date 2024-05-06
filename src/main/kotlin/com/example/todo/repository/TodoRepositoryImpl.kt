package com.example.todo.repository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDatabase
import com.example.todo.repository.TodoReposeitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl(
  val todoDatabase: TodoDatabase
) : TodoReposeitory {

  override fun save(todo: Todo): Todo? {
    
    return todo.index?.let{ index ->
      // update
      findOne(index)?.apply {
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule
        this.updatedAt = LocalDateTime.now()
      }

    }?: kotlin.run{
      // insert
      todo.apply { 
        this.index = ++todoDatabase.index
        this.createdAt = LocalDateTime.now()
        this.updatedAt = LocalDateTime.now()
      }.run {
        todoDatabase.todoList.add(todo)
        this
      }
    }    
  }

  override fun saveAll(todoList: MutableList<Todo>): Boolean {
    return try{
      todoList.forEach{
        save(it)
      }
      true
    }catch (e: Exception){
      false
    }
  }

  override fun delete(index: Int): Boolean {
    return findOne(index)?.let{
      todoDatabase.todoList.remove(it)
      true
    }?:kotlin.run {
      false
    }
  }

  // index가 없을 때, 테스트 코드 작성 필요
  override fun findOne(index: Int): Todo? {
    return todoDatabase.todoList.first { it.index == index }
  }

  override fun findAll(): MutableList<Todo> {
    return todoDatabase.todoList
  }
}
