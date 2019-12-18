package Pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    private ArrayList<Pirates> ship;
    private String shipName = "";

    public Ship() {
        ship = new ArrayList<>();
        this.shipName = shipName;
    }

    public Ship(String shipName) {
        this();
        this.shipName = shipName;
    }

    public void add(Pirates pirate) {
        this.ship.add(pirate);
    }

    public Integer randomGen() {
        Random random = new Random();
        return random.nextInt(15) + 5;
    }

    public void fillShip() {
        for (int i = 0; i < randomGen(); i++) {
            Pirates pirates = new Pirates();
            ship.add(pirates);
            ship.get(0).setCapt();
        }
    }

    public Integer isAlive() {
        int counter = 0;
        for (int i = 0; i < ship.size(); i++) {
            if (this.ship.get(i).getCondition().equals("Alive")) {
                counter++;
            }
        }
        return counter;
    }

    public void battle(Ship ship) {
        System.out.println("----------BATTLE----------");
        int scoreThis = this.isAlive() - this.ship.get(0).getIntoxication();
        int scoreEnemy = ship.isAlive() - ship.ship.get(0).getIntoxication();
        if (scoreThis > scoreEnemy) {
            this.victoryDrink();
            ship.defeat();
            System.out.println(this.shipName + " won the battle!");;
        } else {
            this.defeat();
            ship.victoryDrink();
            System.out.println(ship.shipName + " won the battle!");;
        }
    }

    public Integer randomDrinkOrDie(Integer bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public void victoryDrink() {
        for (int i = 0; i < ship.size(); i++) {
            int number = randomDrinkOrDie(2) +1;
            for (int j = 0; j < number; j++) {
                this.ship.get(i).drinkSomeRum();
            }
        }
    }

    public void defeat() {
        for (int i = 0; i < ship.size(); i++) {
            int number = randomDrinkOrDie(4);
            if (number == 1) {
                this.ship.get(i).die();
            }
        }
    }

    @Override
    public String toString() {
        System.out.println(this.shipName);
        String result = "";
        for (int i = 0; i < ship.size(); i++) {
            result += (i + 1) + ". " + ship.get(i) + "\n";
        }
        return result + "Able to fight: " + this.isAlive();
    }

    //testing the ship battles

    public static void main(String[] args) {

        Ship titanic = new Ship("titanic");
        titanic.fillShip();

        Ship BlackPerl = new Ship("BlackPerl");
        BlackPerl.fillShip();


        System.out.println(titanic.toString());
        System.out.println("-------------------------------------------");
        System.out.println(BlackPerl.toString());

        titanic.battle(BlackPerl);

        System.out.println(titanic.toString());
        System.out.println("-------------------------------------------");
        System.out.println(BlackPerl.toString());
    }

}
