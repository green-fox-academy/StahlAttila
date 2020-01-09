import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class CountLettersTest {

    public String string;
    public CountLetters count;
    public HashMap<Character, Integer> map;

    @Before
    public void init() {
        count = new CountLetters();
        map = new HashMap<>();
    }

    @Test
    public void countLettersTestEquals() {
        string = "";
        assertEquals(map, CountLetters.countLetters(string));
    }

    @Test
    public void countLettersCointansSpecialCharacter() {
        string = "Aasfsga!T%/";
        assertFalse(Objects.requireNonNull(CountLetters.countLetters(string)).containsKey('!'));
    }

    @Test
    public void countLettersNull() {
        string = null;
        assertNull(CountLetters.countLetters(null));
    }
}