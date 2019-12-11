import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name you want to copy.");
        String fileNameFrom = scanner.nextLine();
        System.out.println("Enter the file name you want to copy into.");
        String fileNameTo = scanner.nextLine();
        Path pathCopyFrom = Paths.get("src/" + fileNameFrom + ".txt");
        Path pathCopyTo = Paths.get("src/" + fileNameTo + ".txt");
        copyTo(pathCopyFrom, pathCopyTo);
    }

    private static void copyTo(Path pathFrom, Path pathTo) throws IOException {
        List<String> lines = Files.readAllLines(pathFrom);
        try {
            Files.write(pathTo, lines);
            if(lines.equals(Files.readAllLines(pathTo))){
                System.out.println("The copy was succesfull");
            }else{
                System.out.println("The copy failed!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
