package com.greenfoxacademy.projectmovieapp.repositories;

import com.greenfoxacademy.projectmovieapp.domains.MovieDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDTORepository extends CrudRepository<MovieDTO, Long> {
}
