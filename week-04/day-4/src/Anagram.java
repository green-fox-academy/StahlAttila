import java.util.Arrays;

public class Anagram {

    public static Boolean isAnagram(String word1, String word2) {
        if(word1 == null && word2 == null) {
            return true;
        }else if(word1 == null || word2 == null) {
            return false;
        }
        char[] word1Array = word1.toLowerCase().toCharArray();
        char[] word2Array = word2.toLowerCase().toCharArray();
        Arrays.sort(word1Array);
        Arrays.sort(word2Array);
        return Arrays.equals(word1Array, word2Array);
    }
}