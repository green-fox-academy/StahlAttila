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
        string = "Alma";
        map.put('a', 2);
        map.put('l', 1);
        map.put('m', 1);
        assertEquals(map, CountLetters.countLetters(string));
    }

    @Test
    public void countLettersTestEqualsEmptyMap() {
        string = "";
        assertEquals(map, CountLetters.countLetters(string));
    }

    @Test
    public void countLettersContainsNoneLetters() {
        string = "Aasfsga!T%/123";
        assertFalse((CountLetters.countLetters(string)).containsKey('!'));
        assertFalse((CountLetters.countLetters(string)).containsKey('2'));
    }

    @Test
    public void countLettersNull() {
        string = null;
        assertNull(CountLetters.countLetters(null));
    }
}