package com.restexercise.restexercise.Domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SithText {

    private String sithText;
    private String error;

    public SithText() {
    }

    public SithText(String text) {
        if(text.equals("")){
            this.error = "Feed me some text you have to, padawan young you are. Hmmm.";
        }else{
            this.sithText = sithTextMaker(text);
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty("sith_text")
    public String getSithText() {
        return sithText;
    }

    public void setSithText(String sithText) {
        this.sithText = sithText;
    }

    private Integer randomNum(Integer bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    private String randomYodaWord() {
        String [] yodaWords = {"Arrgh. ", "Hmmm. ", "Uhmm. ", "Yess yess. ", "Err...err..err. ", ""};

        return yodaWords[randomNum(5)] + yodaWords[randomNum(6)];
    }

    private String sithTextMaker(String text) {
        StringBuilder sb = new StringBuilder();
        String [] sentences = text.toLowerCase().split("\\. ");
        for (int i = 0; i < sentences.length; i++) {
            String [] words = sentences[i].replace(".", "").split(" ");
            String temp = "";
            for (int j = 0; j < words.length-1; j+=2) {
                temp = words[j];
                words[j] = words[j+1];
                words[j+1] = temp;
                sentences[i] = Arrays.toString(words);
            }

            sentences[i] = sentences[i].replaceAll(", ", " ");
            sentences[i] = sentences[i].replaceAll("\\[", "");
            sentences[i] = sentences[i].replaceAll("]", "");
            sentences[i] = sentences[i].substring(0,1).toUpperCase()+sentences[i].substring(1);
            sb.append(sentences[i]).append(". ").append(randomYodaWord());
        }

        return String.valueOf(sb);
    }
}
