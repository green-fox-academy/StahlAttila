import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class ProductDatabase<sum> {
    public static void main(String[] args) {
        HashMap<String, Integer> prodDatabase = new HashMap<>();
        prodDatabase.put("Eggs", 200);
        prodDatabase.put("Milk", 200);
        prodDatabase.put("Fish", 400);
        prodDatabase.put("Apples", 125);
        prodDatabase.put("Bread", 50);
        prodDatabase.put("Chicken", 550);
        System.out.println("What are you interested in:");
        //Navigation menu
        System.out.println("-Press \"1\" for cost of a product");
        System.out.println("-Press \"2\" for the most expensive product");
        System.out.println("-Press \"3\" for the average price of the products");
        System.out.println("-Press \"4\" for how many products are below 300");
        System.out.println("-Press \"5\" for anything that costs exactly 125");
        System.out.println("-Press \"6\" for the cheapest product");
        Scanner scanner = new Scanner(System.in);
        Integer input = scanner.nextInt();
        //Selected menu
        if (input == 1) {
            System.out.println("Enter product name: ");
            String productName = scanner.next();
            System.out.println(costOf(productName, prodDatabase));
        } else if (input == 2) {
            System.out.println(mostExpensive(prodDatabase));
        } else if (input == 3) {
            System.out.println("The average price of the products: " + average(prodDatabase));
        }else if (input == 4){
            System.out.println(below300(prodDatabase)+ " products are below 300.");
        }else if (input == 5){
            cost125(prodDatabase);
        }else if (input == 6){
            System.out.println(cheapest(prodDatabase));
        }
    }

    public static Integer costOf(String name, HashMap<String, Integer> map) {
        Integer cost = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (name.equalsIgnoreCase(entry.getKey())) {
                cost = entry.getValue();
            }
        }
        return cost;
    }

    public static Integer mostExpensive(HashMap<String, Integer> map) {
        //not working properly yet
        Integer max = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }return max;
    }

    public static Double average(HashMap<String, Integer> map) {
        Double sum = 0.;
        for (Integer cost : map.values()) {
            sum += cost;
        }
        return sum/map.size();
    }
    public static Integer below300(HashMap<String, Integer> map){
        Integer counter = 0;
        for(Integer cost : map.values()){
            if(300 > cost){
                counter++;
            }
        }
        return counter;
    }
    public static void cost125 (HashMap<String, Integer> map){
        //printing out all the key and values even if they are not 125 without break, but with break only the first one
        for(String key : map.keySet()){
            if(map.get(key) == 125){
                System.out.println(key);
                break;
            }else{
                System.out.println("No product for 125.");
                break;
            }
        }
    }
    public static Integer cheapest (HashMap<String, Integer> map){
        Integer min = 999999999;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        return min;
    }
}
