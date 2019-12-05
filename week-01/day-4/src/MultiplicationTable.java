import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int inputNum = scanner.nextInt();
        //left 0 in on purpose because 0 * number is part of the table as well
        //if i recall correctly from elementary school
        for (int i = 0; i <= inputNum; i++) {
            System.out.println(i +" * " + inputNum  + " = " + (i * inputNum));
        }
    }
}
