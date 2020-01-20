package Exercise12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<Character> characters = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("src/Exercise12/characters.txt"));
        for (String line : lines) {
            String[] s;
            s = line.split(";");
            Character name = new Character(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
            characters.add(name);
        }

        Optional<Double> maxMass = characters.stream().map(Character::getMass).max(Double::compareTo);
        System.out.println(maxMass);
    }
}
