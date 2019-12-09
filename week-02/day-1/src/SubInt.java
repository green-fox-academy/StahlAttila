public class SubInt {
    public static void main(String[] args) {
        int[] array = subInt(1, new int[]{1, 1, 34, 1, 61});
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static int[] subInt(int number, int[] array) {
        int counter = 0;
        int[] indicieArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                indicieArray[counter] = counter;
            }
            counter++;
        }
        return indicieArray;
    }
}

