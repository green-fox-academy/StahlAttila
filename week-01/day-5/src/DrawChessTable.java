import java.util.Scanner;

public class DrawChessTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the field (?x?):");
        int rows = scanner.nextInt();
        for (int i = 0; i < rows ; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < rows/2; j++) {
                    System.out.print("% ");
                }
                System.out.println();
            }else{
                for (int k = 0; k < rows/2; k++) {
                    System.out.print(" %");
                    }
                System.out.println();
            }
        }
    }
}
