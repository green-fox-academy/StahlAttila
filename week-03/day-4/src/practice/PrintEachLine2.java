package practice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrintEachLine2 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("src/practice/my-file.txt");
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
        } catch (Exception e) {
            System.out.println("Unable to read my-file.txt");
        }
    }
}
