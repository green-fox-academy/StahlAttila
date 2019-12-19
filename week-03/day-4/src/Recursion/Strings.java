package Recursion;

public class Strings {
    public static void main(String[] args) {
        String words = "xaapkaxzakkxxx";
        System.out.println(replace(words));
    }
    public static String replace(String words){
        if (words.length() < 1)
            return words;
        if (words.charAt(0) == 'x') {
            words = 'y' + words.substring(1);
        }
        return words.charAt(0) + replace(words.substring(1, words.length()));
    }
}
