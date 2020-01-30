package com.greenfoxacademy.dependencyexercises.Controllers;


import com.greenfoxacademy.dependencyexercises.Services.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GfaController {

    public String current = "";

    StudentInterface studentInterface;

    @Autowired
    public GfaController(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    @GetMapping("/gfa")
    public String main(Model model){
        model.addAttribute("counter", studentInterface.counter());
        current = "/gfa";
        return "gfa-index";
    }

    @GetMapping("/gfa/list")
    public String listAllStudents(Model model){
        model.addAttribute("students", studentInterface.findAll());
        model.addAttribute("counter", studentInterface.counter());
        current= "/gfa/list";
        return "gfa-index";
    }

    @GetMapping("/gfa/add")
    public String newStudentForm(@RequestParam String name, Model model){
        studentInterface.save(name);

        return "redirect:"+current;
    }

    @GetMapping("/gfa/check")
    public String nameChecker(String name, Model model){
         if(studentInterface.findAll().contains(name)){
            model.addAttribute("nameIsInTheList", "The name is in the list!");
        }else{
            model.addAttribute("nameIsInTheList", "The name is not in the list!");
        }
        return "name-checker";
    }


}
