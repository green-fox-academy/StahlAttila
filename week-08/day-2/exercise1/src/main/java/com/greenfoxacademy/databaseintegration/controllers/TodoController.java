package com.greenfoxacademy.databaseintegration.controllers;


import com.greenfoxacademy.databaseintegration.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

    TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping(value = {"/", "/list"})
    public String list(@RequestParam(required = false) String done, Model model){
        if(done.equals("false")){
            model.addAttribute("todos", todoRepository.findAllByDoneIsFalse());
            return "todolist";
        }
        model.addAttribute("todos", todoRepository.findAll());
        return "todolist";
    }

}
