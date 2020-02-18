package com.restexercise.restexercise.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doubling {
    private Integer received;
    private Integer result;
    private String error;

    public Doubling(Integer received, Integer result) {
        this.received = received;
        this.result = result;
    }

    public Doubling() {
        this.received = null;
        this.result = null;
        this.error = "Please provide an input!";
    }

    public String getError() {
        return error;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
