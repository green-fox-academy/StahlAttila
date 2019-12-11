import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversedLines {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/reversed-lines.txt");
        reversedLines(filePath);
    }
    private static void reversedLines(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            StringBuilder stringBuilder = new StringBuilder();
            //convert list to array
            String[] str = new String[lines.size()];
            for (int i = lines.size()-1; i >= 0; i--) {
                str[i] = lines.get(i);
                stringBuilder.append(str[i]);
                stringBuilder.reverse();
            }
            System.out.println(stringBuilder.toString());
            //Reversing the order of the lines

            //Added the lines to a new list


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
