import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {
    public String word1;
    public String word2;
    public Anagram anagram;

    @Before
    public void init() {
        anagram = new Anagram();
    }

    @Test
    public void anagramWordTrueTest() {
        word1 = "Alma";
        word2 = "amla";
        assertTrue(Anagram.isAnagram(word1, word2));
    }

    @Test
    public void anagramTestFalse() {
        word1 = "Alma";
        word2 = "alm";
        assertFalse(Anagram.isAnagram(word1, word2));
    }

    @Test
    public void anagramContainsNull() {
        word1 = null;
        word2 = "aLma";
        assertFalse(Anagram.isAnagram(word1,word2));
    }

    @Test
    public void anagramBothNull() {
        word1 = null;
        word2 = null;
        assertTrue(Anagram.isAnagram(word1,word2));
    }

}