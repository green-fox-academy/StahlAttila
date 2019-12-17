package Sharpie;

public class SharpieMain {
    public static void main(String[] args) {
        Sharpie Blue = new Sharpie("Blue", 3.8);
        System.out.println(Blue.getInkAmount().toString());
        Blue.use();
        System.out.println(Blue.getInkAmount().toString());
    }
}
