package com.greenfoxacademy.springstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;


@Controller
public class HelloWebController {

    private AtomicLong counter = new AtomicLong();
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

    @GetMapping("/web/greeting")
    public String greeting(@RequestParam(value = "size") Integer size, @RequestParam(value = "color") String color, Model model) {

        StringBuilder sb = new StringBuilder();
        for (String s : hellos) {
            sb.append(s).append(" ");
        }
        long loadCounter = counter.incrementAndGet();
        model.addAttribute("color", color);
        model.addAttribute("size", size);
        model.addAttribute("name", " Attila");
        model.addAttribute("counter", loadCounter);
        model.addAttribute("hellos", sb);
        return "greeting";
    }
}
