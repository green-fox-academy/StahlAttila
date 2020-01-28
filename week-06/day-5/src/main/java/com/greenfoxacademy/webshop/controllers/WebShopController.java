package com.greenfoxacademy.webshop.controllers;


import com.greenfoxacademy.webshop.model.ShopItem;
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
    private String currentSite = "";

    public WebShopController() {
        itemList.add(new ShopItem("Running shoes", "Clothes and Shoes", "Nike running shoes for every day sport", 129.99, 5));
        itemList.add(new ShopItem("Printer", "Electronics", "An HP printer to print stuffs", 999.99, 2));
        itemList.add(new ShopItem("Drink", "Snack and beverages", "0,5l bottle of Coca cola", .99, 30));
        itemList.add(new ShopItem("Wokin", "Snack and beverages", "Chicken with fried rice and WOKIN sauce", 4.20, 100));
        itemList.add(new ShopItem("T-shirt", "Clothes and Shoes", "Blue with a lame dinosaur on it", 9.50, 11));
        itemList.add(new ShopItem("T-shirt", "Clothes and Shoes", "Nike white sport shirt", 13., 32));
        itemList.add(new ShopItem("Shorts", "Clothes and Shoes", "Nike black running shorts", 9.50, 11));
        itemList.add(new ShopItem("T-shirt", "Clothes and Shoes", "Red with a cool cat on it", 18.20, 6));
        itemList.add(new ShopItem("Drink", "Snack and beverages", "Löwenbräu shitty beer in a blue can", .35, 54));
        itemList.add(new ShopItem("Drink", "Snack and beverages", "Natur Aqua sparkling mineral water", 1., 19));
        itemList.add(new ShopItem("Snack", "Snack and beverages", "Nógrádi Ropogós salty sticks", .25, 11));
        itemList.add(new ShopItem("Mobile", "Electronics", "Samsung Galaxy S10 black", 350., 8));
        itemList.add(new ShopItem("Monitor", "Electronics", "LG 27\" 120Hz 4K curved monitor", 1120., 36));
        itemList.add(new ShopItem("Mouse", "Electronic", "Hama uRage Gaming mouse", 18.40, 11));
        itemList.add(new ShopItem("Headphones", "Electronics", "AKG white headphones", 24.50, 41));
    }

    @GetMapping("/webshop")
    public String webShop(Model model) {

        model.addAttribute("itemList", itemList);
        return "index";
    }

    @GetMapping("/only-available")
    public String onlyAvailable(Model model) {
        List<ShopItem> availableItems = itemList.stream()
                .filter(i -> i.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
        if (availableItems.size() > 0) {
            model.addAttribute("itemList", availableItems);
            return "index";
        }

        return "redirect:/webshop";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        List<ShopItem> sortedList = itemList.stream()
                                            .sorted(Comparator.comparing(ShopItem :: getPriceInDouble))
                                            .collect(Collectors.toList());
        model.addAttribute("itemList", sortedList);

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
        if (averageStock.isPresent()) {
            model.addAttribute("singleData", "Average stock: " + averageStock.getAsDouble());

            return "singleData";

        } else {
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
    public String searchBar(@RequestParam String searchBar, Model model) {
        List<ShopItem> searchedList = itemList.stream()
                .filter(i -> i.getDescription().toLowerCase().contains(searchBar.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("itemList", searchedList);

        return "index";
    }

    @GetMapping("/more-filters")

    public String moreFilters(Model model) {
        model.addAttribute("itemList", itemList);
        currentSite = "/more-filters";
        return "moreFilters";
    }


    @GetMapping("/filter-by-type")
    public String filterType(Model model, @RequestParam String type) {
        List<ShopItem> clothsAndShoesItems = itemList.stream()
                .filter(i -> i.getType().toLowerCase().equals(type.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("itemList", clothsAndShoesItems);
        currentSite = "/filter-by-type?type=" + type;

        return "moreFilters";
    }

    @GetMapping("/price-in-euro")
    public String priceInEuro(Model model) {
        itemList.forEach(ShopItem::setToEuro);

        model.addAttribute("itemList", itemList);

        return "redirect:" + currentSite;
    }

    @GetMapping("/price-in-forint")
    public String priceInForint(Model model) {
        itemList.forEach(ShopItem::setToForint);

        model.addAttribute("itemList", itemList);

        return "redirect:" + currentSite;
    }

    @GetMapping("/filter-by-price")
    public String filterByPrice(@RequestParam String filter, @RequestParam Integer priceFilter, Model model) {
        List<ShopItem> filteredItems;
        if (filter.equals("Above")) {
            filteredItems = itemList.stream()
                    .filter(i -> Double.parseDouble(i.getPrice()) > priceFilter)
                    .collect(Collectors.toList());
        } else if (filter.equals("Below")) {
            filteredItems = itemList.stream()
                    .filter(i -> Double.parseDouble(i.getPrice()) < priceFilter)
                    .collect(Collectors.toList());
        } else {
            filteredItems = itemList.stream()
                    .filter(i -> Double.valueOf(i.getPrice()).equals(Double.valueOf(priceFilter)))
                    .collect(Collectors.toList());
        }

        model.addAttribute("itemList", filteredItems);
        model.addAttribute("filterField", priceFilter);
        currentSite = "/filter-by-price?filter=" + filter + "&priceFilter=" + priceFilter;

        return "moreFilters";
    }
}
