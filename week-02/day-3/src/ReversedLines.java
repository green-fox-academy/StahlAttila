import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversedLines {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/reversed-order.txt");
        reversedLines(filePath);
    }
    private static void reversedLines(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            //convert list to array
            String[] str = new String[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                str[i] = lines.get(i);
            }
            //Reversing the order of the lines
            String temp;
            for (int i = 0; i < lines.size() / 2; i++) {
                temp = str[i];
                str[i] = str[lines.size() - 1 - i];
                str[lines.size() - 1 - i] = temp;
            }
            //Added the lines to a new list
            List<String> newLines = new ArrayList<>(Arrays.asList(str));
            for (String item : newLines) {
                System.out.println(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
