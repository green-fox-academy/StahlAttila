import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        //import scanner
        Scanner scanner = new Scanner(System.in);
        //asking for username
        System.out.println("Enter username:");
        //the user enters the username
        String inputUsername = scanner.nextLine();
        //prints out the message
        System.out.println("Hello, " + inputUsername);
    }
}
