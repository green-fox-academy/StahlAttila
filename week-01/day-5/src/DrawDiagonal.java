import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if( i== 0 || j == 0 || i==j || i == rows -1 || j == rows -1){
                    System.out.print("%");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
