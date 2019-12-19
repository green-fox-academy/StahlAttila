package Recursion;

public class GreatCommonDivisor {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(42, 14));
    }

    private static Integer greatestCommonDivisor(Integer a, Integer b) {
        if (b != 0){
           return greatestCommonDivisor(b, a % b);
        }else{
            return a;
        }

    }
}
