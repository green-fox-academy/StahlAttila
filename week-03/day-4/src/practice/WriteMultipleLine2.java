package practice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLine2 {
    public static void main(String[] args) {
        Integer numberOfLines = 5;
        Path pathToModify = Paths.get("src/practice/my-file2.txt");
        String word = "apple";
        modifyFile(pathToModify, word, numberOfLines);
    }

    private static void modifyFile(Path path, String word, Integer number) {
        try {
            ArrayList<String> lines = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                lines.add(word);
            }
            Files.write(path, lines);
        }catch (Exception e){
            System.out.println("Could not modify the file");
        }
    }

}
