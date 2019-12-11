import java.io.IOException;
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
            List<String> newLines = new ArrayList<>();
            List<String> lines = Files.readAllLines(path);
            StringBuilder sb = new StringBuilder();

            System.out.println(allChar.toString());


            list[i][5]


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

