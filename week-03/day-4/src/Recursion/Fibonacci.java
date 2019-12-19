package Recursion;

import java.util.ArrayList;

public class Fibonacci {
    static int n = 0;
    static int n1 = 1;
    static int n2 = 1;
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci2(5));
    }

    private static int fibonacci2(int counter){
        if (counter == 3){
            return n2;
        }
        n=n1;
        n1=n2;
        n2 = n + n1;
        return fibonacci2(counter-1);
    }

    private static int fibonacci(int n) {
        if ((n == 0) || (n ==1)){
          return n;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
