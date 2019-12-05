import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        if (inputNum % 2 == 0){
            System.out.println("Your number is even!");
        }else {
            System.out.println("Your number is odd!");
        }
    }
}
