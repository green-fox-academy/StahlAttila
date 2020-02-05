package com.greenfoxacademy.databaseintegration;

import com.greenfoxacademy.databaseintegration.domain.Todo;
import com.greenfoxacademy.databaseintegration.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseintegrationApplication implements CommandLineRunner {

    TodoRepository todoRepository;

    @Autowired
    public DatabaseintegrationApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseintegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*todoRepository.save(new Todo(1L,"Asd1"));
        todoRepository.save(new Todo(123L,"Asd2"));
        todoRepository.save(new Todo(2321L,"Asd2"));
        todoRepository.save(new Todo(3414L,"Asd3"));*/
    }
}
