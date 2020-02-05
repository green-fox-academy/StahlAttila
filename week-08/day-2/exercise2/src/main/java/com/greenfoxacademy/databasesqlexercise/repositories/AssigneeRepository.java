package com.greenfoxacademy.databasesqlexercise.repositories;

import com.greenfoxacademy.databasesqlexercise.domain.Assignee;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    Assignee findByName(String name);
}
