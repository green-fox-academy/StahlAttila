import java.util.Scanner;

public class CountFromTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers where the second is bigger!");
        int inputNum1 = scanner.nextInt();
        int inputNum2 = scanner.nextInt();
        if (inputNum2 <= inputNum1) {
            System.out.println("The second number should be bigger");
        }else{
            for (int i = inputNum1; i < inputNum2; i++) {
                System.out.println(i);
            }
        }
    }
}
