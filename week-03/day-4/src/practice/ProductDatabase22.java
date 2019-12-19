package practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabase22 {
    public static void main(String[] args) {
        HashMap<String, Integer> dataBase = new HashMap<>();
        dataBase.put("Eggs", 200);
        dataBase.put("Milk", 200);
        dataBase.put("Fish", 450);
        dataBase.put("Apple", 150);
        dataBase.put("Bread", 50);
        dataBase.put("Chicken", 550);


        System.out.println(less201(dataBase));
        more150(dataBase);

    }
    public static ArrayList<String> less201(HashMap<String, Integer> map){
        ArrayList<String>listOfProd = new ArrayList<>();
        for (Map.Entry<String, Integer> entry:map.entrySet()) {
            if(entry.getValue()<201){
                listOfProd.add(entry.getKey());
            }
        }return listOfProd;
    }

    public static void more150(HashMap<String, Integer> map){
        for (Map.Entry<String, Integer> entry:map.entrySet()) {
            if(entry.getValue()>150){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
