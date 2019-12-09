public class ChangeElement {
    public static void main(String[] args) {
        int [] s = {1, 2, 3, 8, 5, 6};
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 8){
                s[i] = 4;
            }
            System.out.print(s[i] + " ");
        }
    }
}
