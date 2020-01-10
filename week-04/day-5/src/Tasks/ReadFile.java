package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {

    public static List<String> readFile() {
        try{
            Path filePath = Paths.get("src/tasks.txt");
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Unable to read the file.");
        }

        return null;
    }

}
