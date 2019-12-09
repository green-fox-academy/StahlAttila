import java.util.Scanner;

public class Factorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        System.out.println("The factorial of that number is: "+ factorio(num));

    }
    public static int factorio(int a){
        int factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial *= i;
        }return factorial;
    }
}

