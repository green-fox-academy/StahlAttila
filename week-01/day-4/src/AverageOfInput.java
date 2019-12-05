import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //enter the 5 numbers
        System.out.println("Enter 5 numbers:");
        int inputNum1 = scanner.nextInt();
        int inputNum2 = scanner.nextInt();
        int inputNum3 = scanner.nextInt();
        int inputNum4 = scanner.nextInt();
        int inputNum5 = scanner.nextInt();
        //calculate the results and store them in a new variable
        int sumOfNums = inputNum1 + inputNum2 + inputNum3 + inputNum4 + inputNum5;
        double avgOfNums = (inputNum1 + inputNum2 + inputNum3 + inputNum4 + inputNum5) / 5.;
        //print out the results
        System.out.println("Sum: " + (sumOfNums) + ", " + "Average: "+ (avgOfNums) );
    }
}
