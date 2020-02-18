package com.restexercise.restexercise.Service;

import com.restexercise.restexercise.Domain.Log;
import java.util.List;

public interface LogService  {

    List<Log> findAll();

    void saveLog(Log log);
}
