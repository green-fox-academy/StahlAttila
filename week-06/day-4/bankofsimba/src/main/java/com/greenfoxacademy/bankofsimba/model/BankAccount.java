package com.greenfoxacademy.bankofsimba.model;


public class BankAccount {

    private String name;
    private Double balance;
    private String animalType;
    private String currency;
    private Boolean isKing;
    private Boolean isBad;

    public BankAccount(String name, Double balance, String animalType, Boolean isBad) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.currency = "$";
        this.isKing = false;
        this.isBad = isBad;
    }

    public BankAccount(String name, Double balance, String animalType, Boolean isBad,  Boolean isKing) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.currency = "$";
        this.isKing = isKing;
        this.isBad = isBad;
    }

    public String getKing() {
        if (this.isKing) {
            return "King";
        }else {
            return "Not a king";
        }
    }

    public String getIsBad() {
        if (this.isBad) {
            return "Bad Guy";
        }else {
            return "Good one";
        }
    }

    public void setKing(Boolean king) {
        isKing = king;
    }

    public String getCurrency() {
        return currency;
    }

    public BankAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getKingStyleClass() {
        return isKing ? "gold" : "";
    }
}
