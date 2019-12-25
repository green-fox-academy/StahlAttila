import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        String[] suits = {
                "C", "D", "H", "S"
        };

        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"
        };
        int value = 0;
        System.out.println(startingCards(suits, ranks));

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            if (userInput.equals("more")) {
                System.out.println(moreCard(suits, ranks));
                System.out.println(value);
            }else if (userInput.equals("stop")){
                System.out.println("You quit the game");
                break;
            }
        }
    }

    public static Integer moreCard(String[] suits, String[] ranks){
        int rankValue = 0;
        int rank = randomNum(13);
        System.out.print(suits[randomNum(4)] + "|" + ranks[rank] + "  ");
        if(rank > 8 && rank < 13){
            rankValue += 10;
        }else if(rank == 13){
            rankValue += 11;
        }else
            rankValue += rank + 2;
     return rankValue;
    }

    public static Integer startingCards(String[] suits, String[] ranks){
        int rankValue = 0;
        for (int i = 0; i < 2; i++) {
            int rank = randomNum(13);
            System.out.print(suits[randomNum(4)] + "|" + ranks[rank] + "  ");
            if(rank > 8 && rank < 13){
                rankValue += 10;
            }else if(rank == 13){
                rankValue += 11;
            }else
                rankValue += rank + 2;
        }
        return rankValue;
    }

    public static Integer randomNum(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
}
