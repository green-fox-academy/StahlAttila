import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height of the triangle:");
        int inputTriangLns = scanner.nextInt();
        for (int i = 1; i <= inputTriangLns ; i++) {
            for (int j = 1; j <= i; j++) {
                //the empty spaces makes the triangle look like an even sided triangle
                System.out.print(" ");
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
