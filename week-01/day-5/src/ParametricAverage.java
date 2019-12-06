import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many numbers you want the average and sum of:");
        int totalNums = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < totalNums; i++) {
            System.out.println("Give me the "+ (i+1) + ". number:");
            sum += scanner.nextInt();
        }
        System.out.println("Sum: "+sum +", "+ "Average: "+ ((double)sum/totalNums));
    }
}
