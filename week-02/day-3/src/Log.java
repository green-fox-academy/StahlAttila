import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Log {
    public static void main(String[] args) {
        System.out.println("Enter the name of the file:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        try {
            Path path = Paths.get("src/" + fileName + ".txt");
            System.out.println("The uniqe IP addresses: " + uniqueIP(path));
            System.out.println("The GET/POST ratio is: " + getPostRatio(path));
        } catch (NoSuchFileException e) {
            System.out.println("No such file found.");
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }

    private static ArrayList<String> uniqueIP(Path path) throws IOException {
        ArrayList<String> ipAddresses = new ArrayList<>();
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            if (!ipAddresses.contains(line.substring(27, 38))) {
                ipAddresses.add(line.substring(27, 38));
            }
        }
        return ipAddresses;
    }

    public static Double getPostRatio(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        int counterGet = 0;
        int counterPost = 0;
        for (String line : lines) {
            if (line.contains("GET")) {
                counterGet++;
            } else {
                counterPost++;
            }
        }
        return (double) counterGet / counterPost;
    }
}

