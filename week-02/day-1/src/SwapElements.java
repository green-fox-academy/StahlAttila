public class SwapElements {
    public static void main(String[] args) {
        String [] abc = {"first", "second", "third"};
        for (int i = 0; i < abc.length; i++) {
                String temp = "";
                temp = abc[0];
                abc[0] = abc[2];
                abc[2] = temp;
            System.out.print(abc[i] + " ");
        }
    }
}
