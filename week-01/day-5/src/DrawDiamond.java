import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the rows:");
        int inputRows = scanner.nextInt();
        for (int i = 1; i <= inputRows / 2 ; i++) {
            //using an IF to push with 1 additional space when its an even row because of the additional row
            if(inputRows % 2 == 0){
                for (int j = 1; j <= (inputRows/2) - i ; j++) {
                    System.out.print(" ");
                }

            }else {
                for (int j = 1; j <= (inputRows/2)+1 - i ; j++) {
                    System.out.print(" ");
                }
            }
            for (int k = 1; k < 2 * i; k++) {
                System.out.print("*");
            }

            System.out.println();

        //prints out the pyramid upside down IF loop to check if its an even row or not
        }
        if (inputRows % 2 == 0){
            for (int l1 = (inputRows/2); l1 > 0 ; l1--) {
                for (int m1 = 0; m1 < (inputRows / 2) - l1; m1++) {
                    System.out.print(" ");

                }
                for (int n1 = 0; n1 < (2 * l1) - 1; n1++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }else {
            for (int l1 = (inputRows/2) +1; l1 > 0 ; l1--) {
                for (int m1 = 0; m1 < (inputRows / 2) + 1 - l1; m1++) {
                    System.out.print(" ");

                }
                for (int n1 = 0; n1 < (2 * l1) - 1; n1++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
