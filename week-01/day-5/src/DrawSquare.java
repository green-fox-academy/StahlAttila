import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        for (int i = 0; i <= rows; i++) {
            //prints out the first and the last row
            if (i == 0 || i == rows) {
                for (int j = 1; j <=rows ; j++) {
                    System.out.print("%");
                }
            //prints out the middle
            }else{
                System.out.print("%");
                for (int j = 0; j < rows -2; j++) {
                    System.out.print(" ");
                }
                System.out.print("%");
                }
            System.out.println();
            }
        }
    }

