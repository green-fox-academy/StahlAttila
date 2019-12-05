import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 2 numbers:");
        int inputNum1 = scanner.nextInt();
        int inputNum2 = scanner.nextInt();

        // Checking if one number is bigger than the other as well as if they are even
        if (inputNum1 > inputNum2 && inputNum1 != inputNum2) {
            System.out.println("This is bigger: " + inputNum1);
        }else if (inputNum2 > inputNum1 && inputNum1 != inputNum2) {
            System.out.println("This is bigger: " + inputNum2);
        }else {
            System.out.println("They are even!");
        }
    }
}
