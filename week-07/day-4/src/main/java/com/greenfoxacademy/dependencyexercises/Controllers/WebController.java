package com.greenfoxacademy.dependencyexercises.Controllers;

import com.greenfoxacademy.dependencyexercises.Services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    UtilityService utility;

    @Autowired
    public WebController(UtilityService utility) {
        this.utility = utility;
    }

    @GetMapping("/useful")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/useful/email")
    public String validEmail(@RequestParam String email, Model model){
        model.addAttribute("emailColor", utility.emailValidator(email));
        return "index";
    }

    @GetMapping("/useful/colored")
    public String coloredPage(Model model){
        model.addAttribute("randomColor", utility.randomColor());

        return "coloredPage";
    }

    @GetMapping("/cesar-encode")
    public String cesarEncode(@RequestParam String word, @RequestParam Integer shift, Model model) {
        model.addAttribute("cesarEncode", utility.caesar(word, shift));
        return "index";
    }

    @GetMapping("/cesar-decode")
    public String cesarDecode(@RequestParam String word, @RequestParam Integer shift, Model model) {
        model.addAttribute("cesarDecode", utility.caesar(word, shift));
        return "index";
    }
}
