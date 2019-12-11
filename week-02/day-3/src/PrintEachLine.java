import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
    public static void main(String[] args) {
        try{
            Path filePath = Paths.get("src/index.html");
            List<String> lines = Files.readAllLines(filePath);
            for (String line:lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Unable to read file: index.html");
        }
    }
}
