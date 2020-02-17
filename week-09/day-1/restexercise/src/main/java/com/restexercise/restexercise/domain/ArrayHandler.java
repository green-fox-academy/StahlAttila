package com.restexercise.restexercise.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class ArrayHandler {

    @JsonIgnore
    private String what;
    @JsonIgnore
    private Integer [] numbers;
    private Integer result;
    @JsonProperty("result")
    private Integer[] resultArray;

    public ArrayHandler(String what, Integer[] numbers) {
        switch (what) {
            case "sum":
                this.result = sum(numbers);
                break;
            case "multiply":
                this.result = multiply(numbers);
                break;
            case "double":
                this.resultArray = doubleTheNumbers(numbers);
                break;
        }
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

    public Integer sum(Integer [] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length-1; i++) {
            result += numbers[i];
        }

        return result;
    }

    private Integer multiply(Integer[] numbers) {
        int result = 1;
        for (int i = 0; i < numbers.length-1; i++) {
            result *= numbers[i];
        }

        return result;
    }

    private Integer[] doubleTheNumbers(Integer[] numbers) {
        for (Integer number : numbers) {
            number = number*2;
        }

        return numbers;
    }
}
