import java.util.Scanner;

public class PartyIndicator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of girls coming to the party: ");
        int inputGirls = scanner.nextInt();
        System.out.println("Number of boys coming to the party: ");
        int inputBoys = scanner.nextInt();

        //Comparing the numbers
        if (inputGirls + inputBoys >= 20 && inputBoys - inputGirls == 0) {
            System.out.println("The party is excellent!");
        }else if (inputGirls + inputBoys >= 20 && inputBoys - inputGirls != 0) {
            System.out.println("Quiet cool party!");
        }else if ( inputBoys + inputGirls < 20 && inputGirls != 0) {
            System.out.println("Average party...");
        }else {
            System.out.println("Sausage party");
        }
    }
}
