import java.util.ArrayList;

public class GetIndex {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("asdasd");
        list.add("asd2");
        list.add("asd3");
        list.add("asd4");
        list.add("asd5");
        list.add("asd6");
        System.out.println(getIndex(list, "asd3"));
    }

    private static Integer getIndex(ArrayList<String> list, String value){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(value)){
                return i;
            }
        }

        return -1;
    }
}
