import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import com.example.todo.database.TodoDataBase

@Configuration
class AppConfig {
  
  @Bean(initMethod = "init")
  fun todoDataBase(): TodoDataBase {
    return todoDataBase()
  }
}