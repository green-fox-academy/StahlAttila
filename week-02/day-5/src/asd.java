import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the range (1 - X):");
        int range = scanner.nextInt();
        int numberToGuess = randomGenerator(range);
        //for debugging printing the random number
        //System.out.println(numberToGuess);
        System.out.println("Guess the number between 1 and " + range);
        checkGuess(numberToGuess, setLives(range));

    }
    public static int randomGenerator (int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
    public static void checkGuess (int numberToGuess, int lives){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have (" + lives + ") lives left.");
        for (int i = 0; i < lives; i++) {
            int guess = scanner.nextInt();
            if((lives-1) > i) {
                if (guess > numberToGuess) {
                    System.out.println("The number is lower." + "(Lives left: " + (lives - 1 - i) + ")");
                } else if (guess < numberToGuess) {
                    System.out.println("The number is higher." + "(Lives left: " + (lives - 1 - i) + ")");
                } else {
                    System.out.println("The guess is right, you WON!");
                    break;
                }
            }else {
                System.out.println("You lost! The number was " + numberToGuess);
            }
        }

    }
    public static int setLives(int range){
        int lives = 0;
        if(range >= 1000){
            lives = 75;
        }else if(range >= 500){
            lives = 50;
        }else if(range >= 100){
            lives = 25;
        }else if(range >= 50){
            lives = 10;
        }else {
            lives = 5;
        }return lives;
    }
}
