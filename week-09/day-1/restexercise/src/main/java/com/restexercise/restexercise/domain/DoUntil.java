package com.restexercise.restexercise.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoUntil {

    private Integer result;
    private String error;

    public DoUntil(Integer number, String action) {
        if(number == null){
            this.error = "Please provide a number!";
        }else if(action.equals("sum")) {
            this.result = sumUntil(number);
        }else if(action.equals("factor")){
            this.result = factorial(number);
        }
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer sumUntil(Integer number) {
        Integer result = 0;
        for (int i = 0; i <= number; i++) {
            result += i;
        }

        return result;
    }

    public Integer factorial(Integer number) {
        Integer result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}
