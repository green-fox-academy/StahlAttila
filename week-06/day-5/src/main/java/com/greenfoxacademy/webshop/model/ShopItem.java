package com.greenfoxacademy.webshop.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ShopItem {

    private String name;
    private String description;
    private Double price;
    private Integer quantityOfStock;
    private String currency;
    private Boolean isInEuro;
    private String type;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public ShopItem(String name, String type, String description, Double price, Integer quantityOfStock) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
        this.quantityOfStock = quantityOfStock;
        this.currency = "€";
        this.isInEuro = true;
    }

    public ShopItem() {
    }

    public Double getPriceInDouble(){
        return price;
    }

    public void setToForint(){
        if(this.isInEuro){
           this.currency = "Ft";
           this.isInEuro = false;
            df2.setRoundingMode(RoundingMode.UP);
           this.price = price*337;
        }
    }

    public void setToEuro(){
        if(!this.isInEuro){
            this.currency = "€";
            this.isInEuro = true;
            this.price = price/337;
        }
    }

    public String getType() {
        return type;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return String.format("%.2f", price);
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityOfStock() {
        return quantityOfStock;
    }

    public void setQuantityOfStock(Integer quantityOfStock) {
        this.quantityOfStock = quantityOfStock;
    }
}
