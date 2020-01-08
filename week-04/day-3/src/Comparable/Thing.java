package Comparable;

public class Thing implements Comparable<Thing>{
    private String name;
    private boolean completed;

    public Thing(String name) {
        this.name = name;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name;
    }

    @Override
    public int compareTo(Thing thing) {
        int result = Boolean.compare(this.completed, thing.completed);
        if(result == 0){
            result = this.name.compareTo(thing.name);
        }
        return result;
    }
}