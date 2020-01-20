package Exercise11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<String> readFile() {
        Path path = Paths.get("src/Exercise11/manutd.txt");
        try {
          return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        Map<String, Long> words = Objects.requireNonNull(readFile()).stream()
                                            .map(l->l.split(" "))
                                            .flatMap(Arrays::stream)
                                            .map(s -> s.replaceAll("[\\W+]", ""))
                                            .filter(s->!s.isEmpty())
                                            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

       words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(100).forEach(System.out::println);

    }
}
