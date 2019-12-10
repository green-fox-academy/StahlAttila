import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples","bread", "chicken"));
        System.out.println("Whats in my list?");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        isItin(list, item);
        System.out.println("Your list: " +list.toString());
    }
    public static ArrayList<String> isItin (ArrayList<String> list, String item){
        for (String element : list) {
            if(list.contains(item)){
                System.out.println("The item is in the list.");
                break;
            }else{
                System.out.println("The item is not in the list.\nDo you want to add it to the list? (Y/N)");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if(input.equalsIgnoreCase("y")){
                    list.add(item);
                }
                break;
            }
        }
        return list;
    }
}
