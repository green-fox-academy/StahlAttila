package com.greenfoxacademy.bankofsimba.controller;

import com.greenfoxacademy.bankofsimba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class BankAccountController {
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccountController() {
        bankAccounts.add(new BankAccount("Simba", 2000.85d, "lion", false));
        bankAccounts.add(new BankAccount("Mufasa", 150045.99d, "lion", false, true));
        bankAccounts.add(new BankAccount("Zordon", 40547.75d, "lion", true));
        bankAccounts.add(new BankAccount("Timon", 1.25d, "meerkat", false));
        bankAccounts.add(new BankAccount("Pumba", .85d, "boar", false));
    }


    @GetMapping("/show")
    public String showDetails(Model model) {
        model.addAttribute("owner", bankAccounts.get(3).getName());
        model.addAttribute("balance", bankAccounts.get(3).getBalance());
        model.addAttribute("type", bankAccounts.get(3).getAnimalType());
        model.addAttribute("currency", bankAccounts.get(3).getCurrency());
        return "showDetails";
    }

    @GetMapping("/showAccounts")
    public String showAccounts(Model model) {
        model.addAttribute("accounts", bankAccounts);
        return "showAccounts";
    }

    @GetMapping("/html-text")
    public String testHtmlText(Model model) {
        model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        model.addAttribute("utext", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "htmlTest";
    }

    @GetMapping("/edit")
    public String editAccount(@RequestParam (value = "accountIndex") int accountIndex, Model model) {
        Optional<BankAccount> optBankAcc = bankAccounts.stream().filter(b -> bankAccounts.indexOf(b) == accountIndex).findFirst();

        if(optBankAcc.isPresent()){
            BankAccount account = optBankAcc.get();
            model.addAttribute("account", account);
            model.addAttribute("accounts", bankAccounts);

            return "editAccount";
        }

        return "redirect:/showAccounts";
    }

    @PostMapping("/update-account")
    public String incrementBalance(@RequestParam int accountIndex) {
        Optional<BankAccount> optBankAcc = bankAccounts.stream().filter(b -> bankAccounts.indexOf(b) == accountIndex).findFirst();

        if(optBankAcc.isPresent()){
            BankAccount accountToIncrement = optBankAcc.get();
            if(accountToIncrement.getKing().equals("King")){
                accountToIncrement.setBalance(accountToIncrement.getBalance()+100.);
            }else {
                accountToIncrement.setBalance(accountToIncrement.getBalance()+10.);
            }
            return "redirect:/showAccounts";
        }
        return "redirect:/showAccounts";
    }

    @PostMapping("/add-new-account")
    public String addAccount(@RequestParam String name, @RequestParam Double balance, @RequestParam String animalType, @RequestParam Boolean isBad, @RequestParam Boolean isKing) {
        BankAccount account = new BankAccount(name, balance, animalType, isBad, isKing);
        bankAccounts.add(account);
        return "redirect:showAccounts";
    }







}
