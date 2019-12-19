package Recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(0,5));

    }

    private static Integer power(Integer a, Integer b) {
        if(a == 0){
            return 0;
        }else if (b == 0){
            return 1;
        }else{
            return a * power(a,b-1);
        }
    }
}
