package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class WriteFile {

    public static void writeFile(String string) throws IOException {
        try {
            Path filePath = Paths.get("src/tasks.txt");
            List<String> newList = ReadFile.readFile();
            assert newList != null;
            newList.add("[ ] " + string);
            Files.write(filePath, newList);
        } catch (Exception e) {
            System.out.println("File could not be written.");
        }
    }
}
