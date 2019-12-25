public class test {
    public static void main(String[] args) {
        String[] SUITS = {
                "C", "D", "H", "S"
        };

        String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"
        };

        // initialize deck
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + SUITS[j];
            }
        }
        System.out.println(SUITS[2]);
    }
}
