package com.greenfoxacademy.databasesqlexercise.controllers;

import com.greenfoxacademy.databasesqlexercise.domain.Assignee;
import com.greenfoxacademy.databasesqlexercise.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo/assignees")
public class AssigneeController {

    AssigneeRepository assigneeRepository;

    @Autowired
    public AssigneeController(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    @GetMapping("")
    public String assignees(Model model){
        model.addAttribute("assignees", assigneeRepository.findAll());
        return "assignees";
    }

    @PostMapping("")
    public String addAssignee(Model model, @RequestParam String name, @RequestParam String email){
        assigneeRepository.save(new Assignee(name, email));
        return "redirect:/todo/assignees";
    }

    @GetMapping("/delete")
    public String deleteAssignee(@RequestParam String name){
        assigneeRepository.delete(assigneeRepository.findByName(name));
        return "redirect:/todo/assignees";
    }

    @GetMapping("edit")
    public String editAssignee(@RequestParam String name, Model model){
        model.addAttribute("assignee", assigneeRepository.findByName(name));
        return "edit-assignee";
    }

    /*@PostMapping("edit")
    public String editAssigneeData(@RequestParam long id, @RequestParam String name, @RequestParam String email){
        assigneeRepository.save(new Assignee(id, name, email));
        return "redirect:/todo/assignees";
    }*/


}
