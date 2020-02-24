package com.groot.groot.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CargoRespond {

    private String received;
    private Integer amount;
    private String shipstatus;
    private Boolean ready;
    private String error;

    public CargoRespond(String received, Integer amount, Cargo cargo) {
        if(received == null || amount == null) {
            this.error = "There were no parameters given!";
        }else {
            this.received = received;
            this.amount = amount;
            this.shipstatus = cargo.getShipstatus();
            this.ready = cargo.getReady();
        }

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

}
