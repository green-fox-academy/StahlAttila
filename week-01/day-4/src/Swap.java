public class Swap {
    public static void main(String[] args) {
        int a, b, temp;
        a = 123;
        b = 526;
        // Print before swap
        System.out.println("a= "+ a);
        System.out.println("b= "+ b);

        //swapping
        temp = a;
        a = b;
        b = temp;

        //Print after swap
        System.out.println("a= "+ a);
        System.out.println("b= "+ b);
    }
}
