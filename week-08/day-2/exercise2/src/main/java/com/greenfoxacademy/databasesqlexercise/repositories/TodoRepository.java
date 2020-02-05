package com.greenfoxacademy.databasesqlexercise.repositories;

import com.greenfoxacademy.databasesqlexercise.domain.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findAllByDoneIsFalse();
    List<Todo> findAllByTitleContains(String title);
}
