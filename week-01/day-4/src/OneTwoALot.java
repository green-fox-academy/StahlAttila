import java.util.Scanner;

public class OneTwoALot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();

        //integer version
        if (inputNum <= 0){
            System.out.println("Not enough");
        }else if (inputNum == 1){
            System.out.println("One");
        }else if (inputNum == 2 ){
            System.out.println("Two");
        }else System.out.println("A lot");


        //decimal version just for fun
        double inputNumDouble = scanner.nextDouble();
        if (inputNumDouble < 1){
            System.out.println("Not enough");
        }else if (inputNumDouble == 1){
            System.out.println("One");
        }else if (inputNumDouble > 1 && inputNumDouble < 2 ){
            System.out.println("Between one and two");
        }else if ( inputNumDouble == 2){
            System.out.println("Two");
        }else System.out.println("A lot");

    }
}
