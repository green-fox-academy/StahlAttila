import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {
    private Deck deck;

    @Before
    public void init(){
         deck = new Deck();
    }

    @Test
    public void handIsNotEmpty(){
        assertFalse(PokerTable.getHand(deck).isEmpty());
    }

    @Test
    public void cardsInHandIs5(){
        assertEquals(5, PokerTable.getHand(deck).size());
    }

    @Test
    public void doesntContainSameCard(){

    }

}