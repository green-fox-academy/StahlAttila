package Animal;

public class AnimalMain {
    public static void main(String[] args) {
        Animal cat = new Animal();
        System.out.println("cat thirst and hunger: " + cat.toString());
        cat.play();
        System.out.println("cat thirst and hunger: " + cat.toString());
        //drinking until thrist is 0
        for (int i = 0; i < 51 ; i++) {
            cat.drink();
        }
        //eating until hunger is 0
        for (int i = 0; i < 51 ; i++) {
            cat.eat();
        }
        System.out.println("cat thirst and hunger: " + cat.toString());

    }
}
