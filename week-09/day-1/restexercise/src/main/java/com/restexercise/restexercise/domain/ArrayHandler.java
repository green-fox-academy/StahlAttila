package com.restexercise.restexercise.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArrayHandler {

    @JsonIgnore
    private String what;
    @JsonIgnore
    private Integer [] numbers;
    private Integer result;
    private String error;

    public ArrayHandler(String what, Integer[] numbers) {

        if(what == null || numbers == null) {
            this.error = "Please provide what to do with the numbers!";
        }else if(what.equals("sum")){
            this.result = sum(numbers);
        }else if(what.equals("multiply")){
            this.result = multiply(numbers);
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer[] numbers) {
        this.numbers = numbers;
    }

    public Integer getResult() {
        return result;
    }

    private Integer sum(Integer [] numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }

    private Integer multiply(Integer[] numbers) {
        int result = 1;
        for (Integer number : numbers) {
            result *= number;
        }

        return result;
    }

}
