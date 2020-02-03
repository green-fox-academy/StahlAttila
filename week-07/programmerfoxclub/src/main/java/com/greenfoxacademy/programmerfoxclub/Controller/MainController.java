package com.greenfoxacademy.programmerfoxclub.Controller;

import com.greenfoxacademy.programmerfoxclub.Service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    FoxService foxService;

    @Autowired
    public MainController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/")
    public String main(@RequestParam(required = false) String name, Model model){
        model.addAttribute("list", foxService.foxList());
        if(name == null){
            return "redirect:/login";
        }else if(foxService.isNewFox(name)){
            return "redirect:/login";
        }
        model.addAttribute("fox", foxService.findFox(name));
        model.addAttribute("latestActions", foxService.get5latestAction(foxService.findFox(name)));
        return "index";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        if(foxService.isNewFox(name)){
            foxService.addFox(name);
        }
        return "redirect:/?name="+name;
    }


}
