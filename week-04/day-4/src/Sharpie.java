public class Sharpie {
    private String color;
    private Double width;
    private Double inkAmount = 100d;

    public Sharpie(String color, Double width){
        this.color = color;
        this.width = width;
    }
    public void use(){
        if(inkAmount - 1.5 >= 0){
            inkAmount -= 1.5;
        }
    }
    public Double getInkAmount (){
        return inkAmount;
    }
}
