import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
    public static void main(String[] args) {
        List<String> content = new ArrayList<>();
        content.add("First line");
        try {
            Path filePath = Paths.get("src/new-file.txt");
            Files.write(filePath, content);
        } catch (NoSuchFileException e) {
            System.out.println("Unable to write file: my-file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
