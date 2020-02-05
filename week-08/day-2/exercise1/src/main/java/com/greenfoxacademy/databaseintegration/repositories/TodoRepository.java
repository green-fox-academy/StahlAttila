package com.greenfoxacademy.databaseintegration.repositories;

import com.greenfoxacademy.databaseintegration.domain.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findAllByDoneIsFalse();
}
