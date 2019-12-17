package Counter;

public class CounterMain {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter(5);
        System.out.println(counter1.get());
        System.out.println(counter2.get());

        counter1.add();
        counter1.add(10);
        System.out.println(counter1.get());
        counter1.reset();
        System.out.println(counter1.get());

        counter2.add();
        counter2.add(10);
        System.out.println(counter2.get());
        counter2.reset();
        System.out.println(counter2.get());



    }
}
