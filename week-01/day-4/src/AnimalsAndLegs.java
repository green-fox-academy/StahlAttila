import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of chickens:");
        int inputChickens = scanner.nextInt();
        System.out.println("Enter number of pigs:");
        int inputPigs = scanner.nextInt();

        //Adding up the legs
        int totalLegs = (inputChickens * 2) + (inputPigs * 4);

        //Prints out the number of the legs
        System.out.println("The total number of animal legs: " + totalLegs);
    }
}
