import java.util.Scanner;

public class Cuboid {
    public static void main(String[] args) {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        //prints out the total surface area of the cuboid
        double TSA = 2 * (a * b + b * c + c * a);
        System.out.println("The total surface area is: " + (TSA));

        //prints out the volume of the cuboid
        double vol = a * b * c;
        System.out.println("The volume of the cuboid is: " + (vol));
    }
}
