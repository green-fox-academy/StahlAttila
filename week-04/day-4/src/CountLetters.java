import java.util.HashMap;

public class CountLetters {
    public static HashMap<Character, Integer> countLetters(String string) {
        if (string == null) {
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        string = string.replaceAll("[^A-Za-z]", "");
        char[] chars = string.toLowerCase().toCharArray();
        for (int i = 0; i < string.length(); i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }

        return map;
    }
}
