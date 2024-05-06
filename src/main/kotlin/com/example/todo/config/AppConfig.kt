package com.example.todo.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import com.example.todo.database.TodoDatabase

@Configuration
class AppConfig {
  
  @Bean(initMethod = "init")
  fun todoDatabase(): TodoDatabase {
    return TodoDatabase()
  }
}