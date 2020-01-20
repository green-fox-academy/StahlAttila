package Exercise10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Fox> foxes = new ArrayList<>();
        Fox fox1 = new Fox("Bela", "red", 40);
        Fox fox2 = new Fox("Jani", "black", 2);
        Fox fox3 = new Fox("Mr.Fox", "green", 1);
        Fox fox4 = new Fox("Vukk", "red", 15);
        Fox fox5 = new Fox("GF", "green", 5);
        foxes.add(fox1);
        foxes.add(fox2);
        foxes.add(fox3);
        foxes.add(fox4);
        foxes.add(fox5);

        List<Fox> greenFoxes = foxes.stream().filter(x -> x.getColor().equals("green")).collect(Collectors.toList());
        greenFoxes.forEach((x) -> System.out.println(x.getName()));

        List<Fox> greenFoxesAgeLessThan5 = foxes.stream().filter(x -> x.getColor().equals("green") && x.getAge() < 5).collect(Collectors.toList());
        greenFoxesAgeLessThan5.forEach((x) -> System.out.println(x.getName() + " " + x.getAge()));

        Map<String, Long> colorFrequencies = foxes.stream().collect(Collectors.groupingBy(Fox::getColor, Collectors.counting()));
        System.out.println();
    }
}
