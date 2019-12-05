public class Swap {
    public static void main(String[] args) {
        int a, b, temp;
        a = 123;
        b = 526;
        // Print before swapping
        System.out.println("a= "+ a);
        System.out.println("b= "+ b);

        //after swapping
        temp = a;
        a = b;
        b = temp;
        System.out.println("a= "+ a);
        System.out.println("b= "+ b);
    }
}
