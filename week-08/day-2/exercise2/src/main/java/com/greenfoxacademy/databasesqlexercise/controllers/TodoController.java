package com.greenfoxacademy.databasesqlexercise.controllers;

import com.greenfoxacademy.databasesqlexercise.repositories.AssigneeRepository;
import com.greenfoxacademy.databasesqlexercise.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

    TodoRepository todoRepository;
    AssigneeRepository assigneeRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.assigneeRepository = assigneeRepository;
    }

    @GetMapping(value = {"/", "/list"})
    public String list(Model model, @RequestParam(required = false) String done){

        if(done == null ||!done.equals("false")){

            model.addAttribute("todos", todoRepository.findAll());
            return "todolist";
        }

        model.addAttribute("todos", todoRepository.findAllByDoneIsFalse());
        return "todolist";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String title){
        if(title != null){
            model.addAttribute("todos", todoRepository.findAllByTitleContains(title));
            return "todolist";
        }
        return "redirect:/todo/list";
    }

}
