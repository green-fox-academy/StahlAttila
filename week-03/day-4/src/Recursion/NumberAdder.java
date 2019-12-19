package Recursion;

public class NumberAdder {
    public static void main(String[] args) {
        System.out.println(numberAdder(5));
    }

    private static int numberAdder(int n) {
        if(n == 0){
            return 0;
        }else{
            return numberAdder(n-1)+n;
        }
    }
}
