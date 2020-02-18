package com.restexercise.restexercise.Service;

import com.restexercise.restexercise.Domain.Log;
import com.restexercise.restexercise.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> findAll() {
        return (List<Log>) logRepository.findAll();
    }

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }
}
