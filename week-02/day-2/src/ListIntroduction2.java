import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.util.ArrayList;
import java.util.Arrays;

public class ListIntroduction2 {
    public static void main(String[] args) {
        ArrayList<String> ListA = new ArrayList<String>(Arrays.asList("Apple", "Avocado", "Blueberries", "Durian", "Lychee"));
        ArrayList<String> ListB = new ArrayList<>();
        ListB.addAll(ListA);
        if (ListA.contains("Durian")) {
            System.out.println("Yup");
        } else {
            System.out.println("nope");
        }
        ListB.remove("Durian");
        if (ListB.contains("Durian")) {
            System.out.println("yup");
        } else {
            System.out.println("nope");
        }
        ListA.add(3, "Kiwifruit");
        if(ListA.size()>ListB.size()){
            System.out.println("A is bigger");
        }else if(ListA.size()<ListB.size()){
            System.out.println("B is bigger");
        }else{
            System.out.println("They are the same size");
        }
        System.out.println(ListA.indexOf("Avocado"));
        System.out.println(ListB.indexOf("Durian"));
        ListB.addAll(Arrays.asList("Passion Fruit", "Pomelo"));
        for (String item:ListB) {
            System.out.println(item);
        }
        System.out.println(ListA.get(2));
    }

}
