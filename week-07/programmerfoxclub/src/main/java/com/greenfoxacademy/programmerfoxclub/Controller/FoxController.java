package com.greenfoxacademy.programmerfoxclub.Controller;


import com.greenfoxacademy.programmerfoxclub.Service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

    FoxService foxService;

    @Autowired
    public FoxController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/nutritionStore")
    public String nutritionStore(@RequestParam(required = false) String name, Model model) {
        if (name == null) {
            return "redirect:/login";
        }
        model.addAttribute("fox", foxService.findFox(name));
        return "nutrition-store";
    }

    @PostMapping("/nutritionStore")
    public String changeFoodAndDrink(@RequestParam String name, @RequestParam String food, @RequestParam String drink, Model model) {
        model.addAttribute("fox", foxService.findFox(name));
        foxService.findFox(name).setFood(food);
        foxService.findFox(name).setDrink(drink);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/trickCenter")
    public String trickCenter(@RequestParam(required = false) String name, Model model) {
        if (name == null) {
            return "redirect:/login";
        }
        model.addAttribute("fox", foxService.findFox(name));
        return "trick-center";
    }

    @PostMapping("/trickCenter")
    public String changeTrick(@RequestParam String name, @RequestParam String trick, Model model) {
        model.addAttribute("fox", foxService.findFox(name));
        if (!foxService.findFox(name).getTricks().contains(trick)) {
            foxService.findFox(name).getTricks().add(trick);
        }
        return "redirect:/?name=" + name;
    }


}
