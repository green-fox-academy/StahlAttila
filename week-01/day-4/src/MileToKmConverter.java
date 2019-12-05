import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the distance in miles:");
        double distInMiles = scanner.nextDouble();
        System.out.println("The distance in Km: " + (distInMiles * 1.6));
    }
}
