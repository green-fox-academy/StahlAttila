import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = scanner.nextInt();
        divisor(input);
    }

    private static void divisor(Integer num) {
        try{
            Integer result = 10 / num;
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("divided by 0");
        }
    }
}
