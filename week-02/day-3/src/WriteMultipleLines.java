import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteMultipleLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to put ine the file?");
        String inputWord = scanner.nextLine();
        System.out.println("Enter the name of the file you want to write it in:");
        String path = scanner.nextLine();
        System.out.println("How many times would you like to put that in?");
        Integer inputNumOfLines = scanner.nextInt();
        Path filePath = Paths.get("src/"+ path + ".txt");
        writeMultiLines(filePath, inputNumOfLines, inputWord);
    }

    private static void writeMultiLines(Path path, Integer numOfLines, String word) {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < numOfLines; i++) {
            lines.add(word);
        }
        try {
            if (!Files.exists(path)){
                System.out.println("File did not exist, created a new one!");
            }
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("");;
        }
    }
}
