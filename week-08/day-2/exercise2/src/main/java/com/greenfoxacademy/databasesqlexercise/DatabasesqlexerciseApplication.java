package com.greenfoxacademy.databasesqlexercise;

import com.greenfoxacademy.databasesqlexercise.domain.Todo;
import com.greenfoxacademy.databasesqlexercise.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabasesqlexerciseApplication implements CommandLineRunner {

    TodoRepository todoRepository;

    @Autowired
    public DatabasesqlexerciseApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabasesqlexerciseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*todoRepository.save(new Todo(null, "daily task", false, false));
        todoRepository.save(new Todo(null, "make the bed", true, true));
        todoRepository.save(new Todo(null, "do the washing up", true, false));
        todoRepository.save(new Todo(null, "clean the bathroom", true, true));
        todoRepository.save(new Todo(null, "wipe all surfaces", true, false));
        todoRepository.save(new Todo(null, "remove the grease", true, true));
        todoRepository.save(new Todo(null, "tidy up", false, false));
        todoRepository.save(new Todo(null, "take out the trash", true, true));
        todoRepository.save(new Todo(null, "broom", true, false));
        todoRepository.save(new Todo(null, "sweep the floor", true, true));
        todoRepository.save(new Todo(null, "wash the floor", true, false));
        todoRepository.save(new Todo(null, "mop", true, true));
        todoRepository.save(new Todo(null, "vacuum the carpet", false, false));
        todoRepository.save(new Todo(null, "hoover", true, true));
        todoRepository.save(new Todo(null, "dust the furniture", true, false));*/
    }
}
