import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add the number: ");
        int num = scanner.nextInt();
        System.out.println(sum(num));
    }
    public static int sum(int a){
        int sum = 0;
        for (int i = 0; i <= a; i++) {
            sum += i;
        }return sum;
    }
}
