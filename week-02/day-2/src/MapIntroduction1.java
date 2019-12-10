import java.util.HashMap;

public class MapIntroduction1 {
    public static void main(String[] args) {
        HashMap<Integer, Character> map = new HashMap<>();
        if (map.isEmpty()) {
            System.out.println("The map is empty.");
        } else {
            System.out.println("The map is not empty.");
        }
        map.put(97, 'a');
        map.put(98, 'b');
        map.put(99, 'c');
        map.put(65, 'A');
        map.put(66, 'B');
        map.put(67, 'C');
        for (Integer number : map.keySet()) {
            Character value = map.get(number);
            System.out.println("keys and values: " + number + " " + value);
        }
        map.put(68, 'D');
        System.out.println(map.size());
        System.out.println(map.get(99));
        map.remove(97);
        if(map.containsKey(100)){
            System.out.println("Yes, there is a key 100.");
        }else{
            System.out.println("There isn't key 100.");
        }
        for (Character items:map.values()) {
            System.out.println(items)
            ;

        }
        map.clear();
    }
}

