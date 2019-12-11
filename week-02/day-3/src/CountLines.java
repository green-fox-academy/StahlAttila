import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CountLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = scanner.next();
        printNumberOfLines(fileName);
    }

    private static void printNumberOfLines(String fileName) {
        try{
            Path filePath = Paths.get("src/"+fileName);
            List<String> lines = Files.readAllLines(filePath);
            Integer counter = 0;
            for (int i = 0; i < lines.size(); i++) {
                counter++;
            }
            System.out.println(counter);
        } catch (IOException e) {
            System.out.println("0");
        }
    }
}

