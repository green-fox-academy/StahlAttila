import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the rows:");
        int inputRows = scanner.nextInt();
        for (int i = 1; i <= inputRows / 2 ; i++) {
            for (int j = 1; j <= (inputRows/2) - i ; j++) {
                System.out.print(" ");

            }
            for (int k = 1; k < 2 * i; k++) {
                System.out.print("*");
            }

            System.out.println();

        //prints out the pyramid upside down
        //not working properly, printing out less rows
        }
        for (int l = (inputRows/2) -1; l > 0 ; l--) {
            for (int m = 0; m < (inputRows/2) - l; m++) {
                System.out.print(" ");

            }
            for (int n = 0; n < (2 * l) -1; n++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
