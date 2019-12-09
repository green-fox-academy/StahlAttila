public class IncrementElement {
    public static void main(String[] args) {
        int [] t = {1, 2, 3, 4, 5};
        for (int i = 0; i < t.length; i++) {
            if (i == 2){
                t[2] = t[2] + 1;
            }
            System.out.print(t[i] + " ");
        }
    }
}
