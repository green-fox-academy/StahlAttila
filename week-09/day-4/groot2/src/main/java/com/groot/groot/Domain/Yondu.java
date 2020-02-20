package com.groot.groot.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Yondu {

    private Double distance;
    private Double time;
    private Double speed;
    private String error;

    public Yondu() {
    }

    public Yondu(Double distance, Double time) {
        if(distance != null && time != null){
            this.distance = distance;
            this.time = time;
            this.speed = distance / time;
        } else {
            this.error = "No parameters were given!";
        }

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
