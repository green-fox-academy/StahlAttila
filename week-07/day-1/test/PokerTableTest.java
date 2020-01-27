import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PokerTableTest {

    private List<Card> white;
    private List<Card> black;

    @Before
    public void init(){
        white = new ArrayList<>();
        black = new ArrayList<>();
    }

    @Test
    public void highestWin() throws Exception {
        white.add(new Card(SuitType.C, "2", 2));
        black.add(new Card(SuitType.C, "3", 3));

        assertEquals(black, PokerTable.game(white, black));
    }

    @Test(expected = Exception.class)
    public void drawHighCard() throws Exception {
        white.add(new Card(SuitType.C, "4", 4));
        black.add(new Card(SuitType.S, "4", 4));

        PokerTable.game(white, black);
    }


}