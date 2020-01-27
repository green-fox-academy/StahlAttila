public class Card {

    private SuitType suit;
    private String character;
    private Integer value;

    public Card(SuitType suit, String character, Integer value) {
        this.suit = suit;
        this.character = character;
        this.value = value;
    }

    public SuitType getSuit() {
        return suit;
    }

    public String getCharacter() {
        return character;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return character+suit;
    }
}
