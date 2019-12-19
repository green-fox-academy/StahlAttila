package Recursion;

public class Bunnies {
    public static void main(String[] args) {
        System.out.println(bunnies(5));
    }

    private static int bunnies(int n) {
        if (n == 1){
            return 2;
        }return 2 + bunnies(n-1);
      /*  if(n != 0){
            return n + n +(bunnies(0));

        }return 0;*/

    }
}
