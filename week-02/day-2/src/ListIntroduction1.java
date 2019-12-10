import java.util.ArrayList;

public class ListIntroduction1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());
        list.add("William");
        if (list.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The list is not empty");
        }
        list.add("John");
        list.add("Amanda");
        System.out.println(list.size());
        System.out.println(list.get(2));
        for (String index : list) {
            System.out.println(index);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        list.remove(1);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
        list.clear();
    }
}

