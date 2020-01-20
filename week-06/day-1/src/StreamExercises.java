import java.util.*;
import java.util.stream.Collectors;

public class StreamExercises {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        List<Integer> evenNumbers = numbers1.stream()
                                           .filter(x -> x % 2 == 0)
                                           .collect(Collectors.toList());
        /*evenNumbers.forEach(System.out::println);*/

        List<Integer> numbers2 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        List<Integer> squareOfPositives = numbers2.stream()
                                                  .filter(x -> x >= 0)
                                                  .map(x -> x*x)
                                                  .collect(Collectors.toList());
        /*squareOfPositives.forEach(System.out::println);*/

        List<Integer> numbers3 = Arrays.asList(3, 9, 2, 8, 6, 5);
        List<Integer> squaredValueIdMoreThan20 = numbers3.stream()
                                                         .filter(x -> x*x > 20)
                                                         .collect(Collectors.toList());
        /*squaredValueIdMoreThan20.forEach(System.out::println);*/

        List<Integer> numbers4 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        Double averageOfNumbers = numbers4.stream()
                                          .mapToDouble((nums) -> nums)
                                          .filter(x -> x % 2 != 0)
                                          .average()
                                          .orElse(Double.NaN);
        /*System.out.println(averageOfNumbers);*/

        List<Integer> numbers5 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
        Integer sumOfOddNumbers = numbers5.stream()
                                          .filter(x -> x % 2 != 0)
                                          .mapToInt(nums -> nums)
                                          .sum();
        /*System.out.println(sumOfOddNumbers);*/

        String word = "AsdUztL";
        List<Character> upperCaseChars = word.chars()
                                             .mapToObj(string ->(char) string)
                                             .filter(Character::isUpperCase)
                                             .collect(Collectors.toList());
        /*upperCaseChars.forEach(System.out::println);*/

        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
        String parameter = "A";
        List<String> citiesStartWithA = cities.stream()
                                              .filter(city -> city.startsWith(parameter))
                                              .collect(Collectors.toList());
        /*citiesStartWithA.forEach(System.out::println);*/

        List<Character> chars = Arrays.asList('A', 's', 'd');
        String concatWord = chars.stream()
                                 .map(Object::toString)
                                 .collect(Collectors.joining());
        /*System.out.println(concatWord);*/

        String letterFrequency = "AAasssdd";
        Map<Character, Long> letters = letterFrequency.chars()
                                                   .mapToObj(letter -> (char) letter)
                                                   .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    }
}
