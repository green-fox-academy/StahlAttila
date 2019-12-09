public class CompareLenght {
    public static void main(String[] args) {
        int [] p1 = {1, 2, 3};
        int [] p2 = {4, 5};
        if (p1.length > p2.length){
            System.out.println("p1 is longer");
        }else if (p1.length == p2.length){
            System.out.println("p1 and p2 are equally long");
        }else{
            System.out.println("p2 is longer");
        }
    }
}
