package com.greenfoxacademy.webshop.controllers;


import com.greenfoxacademy.webshop.model.ShopItem;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class WebShopController {

    private List<ShopItem> itemList = new ArrayList<>();

    public WebShopController() {
        itemList.add(new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000., 5));
        itemList.add(new ShopItem("Printer", "An HP printer to print stuffs", 3000., 2));
        itemList.add(new ShopItem("Coca cola", "0,5l bottle of coke", 30., 0));
        itemList.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119., 100));
        itemList.add(new ShopItem("T-shirt", "Red with a cool cat on it", 420., 11));
    }

    @GetMapping("/webshop")
    public String webShop(Model model){

        model.addAttribute("itemList", itemList);
        return "index";
    }

    @GetMapping("/only-available")
    public String onlyAvailable(Model model){
        List<ShopItem> availableItems = itemList.stream()
                                                .filter(i -> i.getQuantityOfStock() > 0)
                                                .collect(Collectors.toList());
        if(availableItems.size()>0){
            model.addAttribute("itemList", availableItems);
            return "index";
        }

        return "redirect:/webshop";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        List<ShopItem> cheapestFirst = itemList.stream()
                                               .sorted(Comparator.comparing(ShopItem::getPrice))
                                               .collect(Collectors.toList());
        model.addAttribute("itemList", cheapestFirst);

        return "index";
    }

    @GetMapping("/contains-nike")
    public String containsNike(Model model) {
        List<ShopItem> containsNike = itemList.stream()
                                              .filter(i -> i.getDescription().toLowerCase().contains("nike"))
                                              .collect(Collectors.toList());
        model.addAttribute("itemList", containsNike);

        return "index";
    }

    @GetMapping("average-stock")
    public String averageStock(Model model) {
        OptionalDouble averageStock = itemList.stream()
                                              .mapToDouble(ShopItem::getQuantityOfStock)
                                              .average();
        if(averageStock.isPresent()){
            model.addAttribute("singleData", "Average stock: " +averageStock.getAsDouble());

            return "singleData";

        }else {
            return "redirect:/webshop";
        }
    }

    @GetMapping("/most-expensive")
    public String mostExpensive(Model model) {
        List<ShopItem> mostExpensiveFirst = itemList.stream()
                .sorted(Comparator.comparing(ShopItem::getPrice).reversed())
                .collect(Collectors.toList());

        model.addAttribute("singleData", mostExpensiveFirst.get(0).getDescription());

        return "singleData";
    }

    @PostMapping("/search-for")
    public String searchBar(@RequestParam String searchBar, Model model){
        List<ShopItem> searchedList = itemList.stream()
                                              .filter(i -> i.getDescription().toLowerCase().contains(searchBar.toLowerCase()))
                                              .collect(Collectors.toList());

        model.addAttribute("itemList", searchedList);

        return "index";

    }
}
