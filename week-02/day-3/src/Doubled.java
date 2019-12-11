import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//bugos
public class Doubled {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("src/duplicated-chars.txt");
        doubled(filePath);
    }

    private static void doubled(Path path) throws IOException {
        try {
            List<String> lines = Files.readAllLines(path);
            StringBuilder removeDouble = new StringBuilder();
            String stringLines = lines.toString();
            char [] chars = stringLines.toCharArray();
            for (int i = 1; i < stringLines.length()-1; i+=2) {
                removeDouble.append(chars[i]);
            }
            System.out.println(removeDouble.toString());
            System.out.println("------------------------");
            System.out.println(removeDouble.toString().replace(",[*]", "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

