package com.groot.groot.Domain;

public class Food {

    private String name;
    private Double amount;
    private Double calorie;

    public Food() {
    }

    public Food(String name, Double amount, Double calorie) {
        this.name = name;
        this.amount = amount;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }
}
