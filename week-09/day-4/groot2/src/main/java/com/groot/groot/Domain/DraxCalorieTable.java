package com.groot.groot.Domain;

import java.util.ArrayList;
import java.util.List;

public class DraxCalorieTable {

    private List<Food> foodList;


    public DraxCalorieTable() {
        this.foodList = new ArrayList<>();
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public void removeFood(int index) {
            this.foodList.remove(index);
    }

}
