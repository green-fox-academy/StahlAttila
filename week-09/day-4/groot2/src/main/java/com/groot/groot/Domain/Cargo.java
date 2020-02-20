package com.groot.groot.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cargo {

    private Integer caliber25;
    private Integer caliber30;
    private Integer caliber50;
    private String shipstatus;
    private Boolean ready;
    private Integer maximumAmount;
    private Cargo cargo;

    public Cargo() {
        this.caliber25 = 0;
        this.caliber30 = 0;
        this.caliber50 = 0;
        this.shipstatus = "empty";
        this.ready = false;
    }

    public Integer getCaliber25() {
        return caliber25;
    }

    public void setCaliber25(Integer caliber25) {
        this.caliber25 = caliber25;
    }

    public Integer getCaliber30() {
        return caliber30;
    }

    public void setCaliber30(Integer caliber30) {
        this.caliber30 = caliber30;
    }

    public Integer getCaliber50() {
        return caliber50;
    }

    public void setCaliber50(Integer caliber50) {
        this.caliber50 = caliber50;
    }

    public String getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(String shipstatus) {
        this.shipstatus = shipstatus;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public Integer getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Integer maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public void fillCargo(String caliber, Integer amount) {
        int currentAmount = this.caliber25 + this.caliber30 + this.caliber50;
        if(caliber.contains("25")) {
            this.caliber25 += amount;
        } else if(caliber.contains("30")) {
            this.caliber30 += amount;
        } else if(caliber.contains("50")) {
            this.caliber50 += amount;
        }
        if(currentAmount + amount > 0 && currentAmount + amount <= 12500) {
            this.shipstatus = 100 * (this.caliber25 + this.caliber30 + this.caliber50) / 12500 +"%";
        } else if( currentAmount + amount == 0) {
            this.shipstatus = "empty";
        } else {
            this.shipstatus = "overloaded";
        }

        if(this.shipstatus.equals("100%")) {
            this.ready = true;
        }

    }
}
