import java.util.ArrayList;
import java.util.Arrays;

public class PersonalFinance {
    public static void main(String[] args) {
        ArrayList<Integer> expenses = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));
        System.out.println(average(expenses));
    }

    public static Integer spend(ArrayList<Integer> al) {
        Integer sum = 0;
        for (int i = 0; i < al.size(); i++) {
            sum = sum + al.get(i);
        }
        return sum;
    }

    public static Integer greatestExpense(ArrayList<Integer> al) {
        Integer max = 1;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) > max) {
                max = al.get(i);
            }
        }
        return max;
    }

    public static Integer cheapestExpense(ArrayList<Integer> al) {
        Integer min = 999999999;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) < min) {
                min = al.get(i);
            }
        }
        return min;
    }

    public static Double average(ArrayList<Integer> al) {
        Double sum = 0.;
        for (int i = 0; i < al.size(); i++) {
            sum += al.get(i);
        }
        return sum / al.size();
    }
}
