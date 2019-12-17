package Animal;

public class Animal {
    Integer hunger;
    Integer thirst;

    public Animal(){
        this.hunger = 50;
        this.thirst = 50;
    }
    public void eat(){
        --hunger;
    }
    public void drink(){
        --thirst;
    }
    public void play(){
        ++hunger;
        ++thirst;
    }
    public String toString(){
        return this.thirst + " "+ this.hunger;
    }

}
