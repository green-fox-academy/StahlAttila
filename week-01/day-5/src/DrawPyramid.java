import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height of the pyramid:");
        int inputNum = scanner.nextInt();
        //empty line after the number so it looks better
        System.out.println();
        //print out as many line as you say
        for (int i = 1; i <= inputNum ; i++) {
            //determines and prints how many spaces are before the stars(every line -1)
            for (int j = 1; j <= inputNum - i ; j++) {
                System.out.print(" ");
            //determines and prints the number of stars on the line
            }
            for (int k = 1; k < 2 * i; k++) {
                System.out.print("*");
            }
            //finishes the row
            System.out.println();

        }
    }
}
