package Recursion;

public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumDigits(123));
    }

    private static Integer sumDigits(Integer n) {
        if(n/10 == 0){
            return n;
        }else{
            return n % 10 + sumDigits(n/10);
        }
    }
}
