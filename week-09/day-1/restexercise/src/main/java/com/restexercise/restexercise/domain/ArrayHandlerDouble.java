package com.restexercise.restexercise.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArrayHandlerDouble extends ArrayHandler {

    @JsonIgnore
    private String what;
    @JsonIgnore
    private Integer [] numbers;
    private Integer [] resultArray;


    public ArrayHandlerDouble(String what, Integer[] numbers) {
        super(what, numbers);
        this.resultArray = doubleTheNumbers(numbers);
    }

    @Override
    public String getWhat() {
        return what;
    }

    @Override
    public void setWhat(String what) {
        this.what = what;
    }

    @Override
    public Integer[] getNumbers() {
        return numbers;
    }

    @Override
    public void setNumbers(Integer[] numbers) {
        this.numbers = numbers;
    }

    public void setResult(Integer[] result) {
        this.resultArray = result;
    }

    @JsonProperty("result")
    public Integer[] getResultArray() {
        return resultArray;
    }

    public void setResultArray(Integer[] resultArray) {
        this.resultArray = resultArray;
    }

    private Integer[] doubleTheNumbers(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i]*2;
        }

        return numbers;
    }
}
