package com.groot.groot.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CargoRespond extends Cargo {

    private Integer caliber25;
    private Integer caliber30;
    private Integer caliber50;
    private String received;
    private Integer amount;
    private String shipstatus;
    private Boolean ready;

    public CargoRespond(String received, Integer amount, Cargo cargo) {
        super();
        this.received = received;
        this.amount = amount;
        this.shipstatus = cargo.getShipstatus();
        this.ready = cargo.getReady();
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String getShipstatus() {
        return shipstatus;
    }

    @Override
    public void setShipstatus(String shipstatus) {
        this.shipstatus = shipstatus;
    }

    @Override
    public Boolean getReady() {
        return ready;
    }

    @Override
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    @JsonIgnore
    @Override
    public Integer getCaliber25() {
        return caliber25;
    }


    @Override
    public void setCaliber25(Integer caliber25) {
        this.caliber25 = caliber25;
    }

    @JsonIgnore
    @Override
    public Integer getCaliber30() {
        return caliber30;
    }

    @Override
    public void setCaliber30(Integer caliber30) {
        this.caliber30 = caliber30;
    }

    @JsonIgnore
    @Override
    public Integer getCaliber50() {
        return caliber50;
    }

    @Override
    public void setCaliber50(Integer caliber50) {
        this.caliber50 = caliber50;
    }
}
