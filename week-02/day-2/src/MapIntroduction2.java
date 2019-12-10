import java.util.HashMap;
import java.util.Iterator;

public class MapIntroduction2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("978-1-60309-452-8", "A Letter to Jo");
        map.put("978-1-60309-459-7", "Lupus");
        map.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        map.put("978-1-60309-461-0", "The Lab");
        for (String value : map.keySet()) {
            String key = map.get(value);
            System.out.println(key + " (ISBN: " + value + ")");
        }
        System.out.println("-------------------");
        map.remove("978-1-60309-444-3");
        for (String value : map.keySet()) {
            String key = map.get(value);
            System.out.println(key + " (ISBN: " + value + ")");
        }
        System.out.println("----------------");
        String valueToBeRemoved = "The Lab";
        //map.entrySet().removeIf(valueToBeRemoved.equals(entry.getValue()));
        /*for (String value : map.keySet()) {
            String key = map.get(value);
            if (map.get(value).equals("The Lab")) {
                map.remove(key);
            }
        for (String value2 : map.keySet()) {
            String key2 = map.get(value);
            System.out.println(key2 + " (ISBN: " + value2 + ")");

            map.put("978-1-60309-450-4", "They Called Us Enemey");
            map.put("978-1-60309-453-5", "Why Did We Trust Him?");

        for (String key : map.entrySet()) {
        if (map.containsValue(map.containsKey("478-0-61159-424-8"))) ;

                }*/

   }
}


