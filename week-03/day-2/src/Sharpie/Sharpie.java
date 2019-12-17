package Sharpie;

public class Sharpie {
    private String color;
    private Double width;
    private Double inkAmount;

    public Sharpie(String color, Double width){
        this.color = color;
        this.width = width;
        this.inkAmount = 100d;
    }
    public void use(){
        inkAmount -= 1.5;
    }
    public Double getInkAmount (){
        return inkAmount;
    }
}
