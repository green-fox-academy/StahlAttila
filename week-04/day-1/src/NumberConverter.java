import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberConverter {
    public static void main(String[] args) {
        Integer number = 745;
        numberConverter(number);

        stringToNumberConverter("seven hundred and forty four");
    }

    private static void numberConverter(Integer number) {
        ArrayList<Integer> digits = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "ten");
        map2.put(2, "twenty");
        map2.put(3, "thirty");
        map2.put(4, "forty");
        map2.put(5, "fifty");
        map2.put(6, "sixty");
        map2.put(7, "seventy");
        map2.put(8, "eighty");
        map2.put(9, "ninety");

        while(number > 0){
            digits.add(number % 10);
            number = number / 10;
        }
        if(digits.size() == 3){
            System.out.println(map.get(digits.get(digits.size()-1)) + " hundred and " + map2.get(digits.get(digits.size()-2)) +" " + map.get(digits.get(digits.size()-3)));
        }

    }

    public static void stringToNumberConverter(String word) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(4, "for");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "ten");
        map2.put(2, "twenty");
        map2.put(3, "thirty");
        map2.put(4, "forty");
        map2.put(5, "fifty");
        map2.put(6, "sixty");
        map2.put(7, "seventy");
        map2.put(8, "eighty");
        map2.put(9, "ninety");

        word = word.replace(" hundred and", "");
        word = word.replace("ty", "");
        ArrayList<String> wordSplit = new ArrayList<String>(Arrays.asList(word.split(" ")));
        StringBuilder wordToString = new StringBuilder();
        System.out.println(wordSplit.toString());
        for (int j = 0; j < wordSplit.size(); j++) {
            for (int i = 0; i < map.size(); i++) {
                if (map.get(i + 1).equals(wordSplit.get(j))) {
                    wordToString.append(i+1);
                }
            }
        }
        System.out.println(wordToString);
    }
}
