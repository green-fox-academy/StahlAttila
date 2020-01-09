import java.util.ArrayList;

public class Sum {
    public Integer sum(ArrayList<Integer> list) {
        Integer sum = 0;
        if(list != null) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) != null){
                    sum += list.get(i);
                }else{
                    return 0;
                }
            }
        }else{
            return 0;
        }
        return sum;
    }
}
