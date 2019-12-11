import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Log {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/log.txt");
        System.out.println("The uniqe IP addresses: " + uniqueIP(path));
        System.out.println("The GET/POST ratio is: " + getPost(path));
    }

    private static ArrayList<String> uniqueIP(Path path) {
        ArrayList<String> ipAddresses = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                if (!ipAddresses.contains(line.substring(27, 39))) {
                    ipAddresses.add(line.substring(27, 39));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ipAddresses;
    }

    public static Double getPost(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Integer counterGet = 0;
        Integer counterPost = 0;
        for (String line : lines) {
            if (line.contains("GET")) {
                counterGet++;
            } else {
                counterPost++;
            }

        }
        return counterGet.doubleValue()/counterPost;
    }
    
}

