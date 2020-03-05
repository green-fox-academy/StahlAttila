package com.greenfoxacademy.projectmovieapp.repositories;

import com.greenfoxacademy.projectmovieapp.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
