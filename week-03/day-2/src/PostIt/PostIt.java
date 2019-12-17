package PostIt;

public class PostIt {
    private String backgroundColor;
    private String text;
    private String textColor;

    public PostIt(String backgroundColor, String textColor, String text){
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.text = text;
    }

    public String getBackgroundColor(){
        return backgroundColor;
    }
    public String getTextColor(){
        return textColor;
    }
    public String getText(){
        return text;
    }
    public String  toString(){
        return "Background color: "+ this.getBackgroundColor() + " Textcolor: " + this.getTextColor() + " text: " + this.getText();
    }
}
