package Counter;

public class Counter {
    private Integer counter = 0;
    private Integer temp = 0;

    public Counter(){
        this.counter = counter;
    }
    public Counter(Integer baseValue){
        this.temp = baseValue;
        this.counter = baseValue;
    }
    public void add(){
        ++counter;
    }
    public Integer get(){
        return counter;
    }
    public void add(Integer number){
        counter += number;
    }
    public void reset(){
        this.counter = temp;
    }
}
