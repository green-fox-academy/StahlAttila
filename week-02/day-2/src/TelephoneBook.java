import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {
    public static void main(String[] args) {
        HashMap<String, String> tBook = new HashMap<>();
        tBook.put("William A. Lathan", "405-709-1865");
        tBook.put("John K. Miller", "402-247-8568");
        tBook.put("Hortensia E. Foster", "606-481-6467");
        tBook.put("Amanda D. Newland", "319-243-5613");
        tBook.put("Brooke P. Askew", "307-687-2982");
        //isIn function not working properly, only Hortesia E. is returning true
        isIn(tBook, "William A. Lathan");
        //to check the entire hashmap
        for(Map.Entry<String, String> entry:tBook.entrySet()){
            System.out.println("keys: "+ entry.getKey() +" | "+ entry.getValue());
        }

    }

    public static String getNumber(HashMap<String, String> book, String name) {
        String value = "";
        for (Map.Entry<String, String> entry : book.entrySet()) {
            if (name.equals(entry.getKey())) {
                value = entry.getValue();
            }
        }
        return value;
    }

    public static String getName(HashMap<String, String> book, String number) {
        String key = "";
        for (Map.Entry<String, String> entry : book.entrySet()) {
            if (number.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }
    public static void isIn(HashMap<String, String> book, String name){
        String isIn = "";
        for (Map.Entry<String, String> entry : book.entrySet()) {
            if (entry.getKey().contains(name)){
                isIn = "The name is in the phone book";
            }else{
                isIn = "The name is not in the phone book";
            }
        }
        System.out.println(isIn);
    }

}
