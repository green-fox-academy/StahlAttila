package Tasks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RemoveTask {

    public static void removeLine(Integer index) {
        try {
            Path filePath = Paths.get("src/tasks.txt");
            List<String> newList = ReadFile.readFile();
            assert newList != null;
            newList.remove(index - 1);
            Files.write(filePath, newList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to remove: index is out of bound");
        } catch (Exception e) {
            System.out.println("File could not be written.");
        }
    }

}
