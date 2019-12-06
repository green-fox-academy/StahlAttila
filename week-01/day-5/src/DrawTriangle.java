import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height of the triangle:");
        int inputTriangLns = scanner.nextInt();
        //empty space to separate the number from the triangle
        System.out.println("");
        for (int i = 0; i <= inputTriangLns ; i++) {
            for (int j = 0; j <= i; j++) {
                //the empty spaces makes the triangle look like an even sided triangle
                System.out.print(" ");
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
