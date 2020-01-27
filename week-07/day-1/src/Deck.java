import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> deck = new ArrayList<>();

    public Deck() {
        deck.add(new Card(SuitType.H, "2", 2));
        deck.add(new Card(SuitType.H, "3", 3));
        deck.add(new Card(SuitType.H, "4", 4));
        deck.add(new Card(SuitType.H, "5", 5));
        deck.add(new Card(SuitType.H, "6", 6));
        deck.add(new Card(SuitType.H, "7", 7));
        deck.add(new Card(SuitType.H, "8", 8));
        deck.add(new Card(SuitType.H, "9", 9));
        deck.add(new Card(SuitType.H, "10", 10));
        deck.add(new Card(SuitType.H, "J", 11));
        deck.add(new Card(SuitType.H, "Q", 12));
        deck.add(new Card(SuitType.H, "K", 13));
        deck.add(new Card(SuitType.H, "A", 14));

        deck.add(new Card(SuitType.C, "2", 2));
        deck.add(new Card(SuitType.C, "3", 3));
        deck.add(new Card(SuitType.C, "4", 4));
        deck.add(new Card(SuitType.C, "5", 5));
        deck.add(new Card(SuitType.C, "6", 6));
        deck.add(new Card(SuitType.C, "7", 7));
        deck.add(new Card(SuitType.C, "8", 8));
        deck.add(new Card(SuitType.C, "9", 9));
        deck.add(new Card(SuitType.C, "10", 10));
        deck.add(new Card(SuitType.C, "J", 11));
        deck.add(new Card(SuitType.C, "Q", 12));
        deck.add(new Card(SuitType.C, "K", 13));
        deck.add(new Card(SuitType.C, "A", 14));

        deck.add(new Card(SuitType.S, "2", 2));
        deck.add(new Card(SuitType.S, "3", 3));
        deck.add(new Card(SuitType.S, "4", 4));
        deck.add(new Card(SuitType.S, "5", 5));
        deck.add(new Card(SuitType.S, "6", 6));
        deck.add(new Card(SuitType.S, "7", 7));
        deck.add(new Card(SuitType.S, "8", 8));
        deck.add(new Card(SuitType.S, "9", 9));
        deck.add(new Card(SuitType.S, "10", 10));
        deck.add(new Card(SuitType.S, "J", 11));
        deck.add(new Card(SuitType.S, "Q", 12));
        deck.add(new Card(SuitType.S, "K", 13));
        deck.add(new Card(SuitType.S, "A", 14));

        deck.add(new Card(SuitType.D, "2", 2));
        deck.add(new Card(SuitType.D, "3", 3));
        deck.add(new Card(SuitType.D, "4", 4));
        deck.add(new Card(SuitType.D, "5", 5));
        deck.add(new Card(SuitType.D, "6", 6));
        deck.add(new Card(SuitType.D, "7", 7));
        deck.add(new Card(SuitType.D, "8", 8));
        deck.add(new Card(SuitType.D, "9", 9));
        deck.add(new Card(SuitType.D, "10", 10));
        deck.add(new Card(SuitType.D, "J", 11));
        deck.add(new Card(SuitType.D, "Q", 12));
        deck.add(new Card(SuitType.D, "K", 13));
        deck.add(new Card(SuitType.D, "A", 14));
    }

    public void removeCard(Card card){
        deck.remove(card);
    }

    public Card getCard(int index){
        return deck.get(index);
    }

    public List<Card> getDeck(){
        return deck;
    }
}
