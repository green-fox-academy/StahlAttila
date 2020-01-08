package Zoo;

import main.java.music.StringedInstrument;

public abstract class Animal {
    protected String name;
    protected Integer age;
    protected Gender gender;
    protected Integer numberOfLegs;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String breed();

    public abstract void eat();

    public abstract void move();
}
