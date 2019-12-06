import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int random = (int)(Math.random() * 100 + 1);
        /*showing the number to guess for debugging purposes
        System.out.println(random);*/

        System.out.println("Guess the number!");
        for (int i = 0; i < i +1; i++) {
            int inputNum = scanner.nextInt();
            if (random == inputNum) {
                System.out.println("You found the number: " + random);
                break;
            }else if (random > inputNum) {
                System.out.println("The stored number is higher");
            }else{
                System.out.println("The stored number is lower");
            }

        }


    }
}
