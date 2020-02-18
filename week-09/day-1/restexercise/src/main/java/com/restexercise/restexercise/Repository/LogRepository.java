package com.restexercise.restexercise.Repository;

import com.restexercise.restexercise.Domain.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository  extends CrudRepository<Log, Long> {
}
