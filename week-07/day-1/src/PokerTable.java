import java.util.*;
import java.util.stream.Collectors;

public class PokerTable {

    private Deck deck = new Deck();

    public static List<Card> getHand(Deck deck){
     List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Card randomCard = deck.getCard(randomNumber(deck.getDeck().size()));
            hand.add(randomCard);
            deck.removeCard(randomCard);
        }
     return hand;
    }

    public static Integer randomNumber(Integer bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static List<Card> game(List<Card> white, List<Card> black) throws Exception {
        List<Card> sortedWhite = white.stream()
                .sorted(Comparator.comparingInt(Card::getValue).reversed())
                .collect(Collectors.toList());
        List<Card> sortedBlack = black.stream()
                .sorted(Comparator.comparingInt(Card::getValue).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sortedBlack.size(); i++) {
            if (sortedBlack.get(i).getValue() > sortedWhite.get(i).getValue()) {
                return black;
            } else if (sortedWhite.get(i).getValue() > sortedBlack.get(i).getValue()) {
                return white;
            }


        }
        throw new Exception("It's a Tie!");
    }

    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();
        List<Card> player1 = getHand(deck);
        List<Card> player2 = getHand(deck);

        player1.forEach(c -> System.out.println(c.toString()));
        System.out.println("-------------------------");
        player2.forEach(c -> System.out.println(c.toString()));

        game(player1, player2);

    }

}
