package practice;

public class ReverseList2 {
    public static void main(String[] args) {
        int [] aj = new int [] {3, 4, 5, 6, 7};
        int temp = 0;
        for (int i = 0; i < aj.length/2; i++) {
            temp = aj[i];
            aj[i] = aj[aj.length-1-i];
            aj[aj.length-1-i] = temp;
        }
        for (int number:aj) {
            System.out.print(number);
        }
    }
}
