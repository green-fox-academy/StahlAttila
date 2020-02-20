package com.groot.groot.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Groot {

    private String received;
    private String translated;
    private String error;

    public Groot() {
    }

    public Groot(String received) {
        if(received != null) {
            this.received = received;
            this.translated = "I'm Groot!";
        } else {
          this.error = "I'm Groot!";
        }

    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
