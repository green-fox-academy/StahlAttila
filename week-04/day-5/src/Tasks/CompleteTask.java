package Tasks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CompleteTask {

    public static void completeTask(String task) {
        try {
            Path filePath = Paths.get("src/tasks.txt");
            List<String> newList = ReadFile.readFile();
            assert newList != null;
            for (String line : newList) {
                if (line.equals("[ ] " + task)) {
                    newList.set(newList.indexOf(line), line.replace("[ ]", "[X]"));
                }
            }
            Files.write(filePath, newList);
        } catch (Exception e) {
            System.out.println("File could not be written.");
        }
    }
}

