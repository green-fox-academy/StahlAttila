package CharSequence;

public class Main {
    public static void main(String[] args) {
        Gnirts word = new Gnirts("this example");
        String wordNormal = "asddsauhg";
        System.out.println(word.charAt(11));
        System.out.println(word.subSequence(2, 4));


        Shifter shiftedWord = new Shifter("example", 2);
        System.out.println(shiftedWord.charAt(0));

    }
}
