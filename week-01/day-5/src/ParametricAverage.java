import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many numbers you want the average and sum of:");
        int totalNums = scanner.nextInt();
        int sum = 0;
        double avg = 0;
        for (int i = 1; i <= totalNums; i++) {
            System.out.println("Give me the "+ i + ". number:");
            int nums = scanner.nextInt();
            sum += nums;
            avg = sum / totalNums;
        }

        System.out.println("Sum: "+sum +", "+ "Average: "+ avg);
    }
}
