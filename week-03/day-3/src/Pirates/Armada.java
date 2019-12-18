package Pirates;

import java.util.ArrayList;
import java.util.Random;

public class Armada {
    private ArrayList<Ship> armada;
    private String armadaName="";

    public Armada(String armadaName){
        armada = new ArrayList<>();
        this.armadaName = armadaName;
    }

    public void add(Ship ship){
        armada.add(ship);
    }

    public void fillArmada(){
        for (int i = 0; i < randomShipNumber(4)+1; i++) {
            Ship ship = new Ship();
            ship.fillShip();
        }
    }

    public Integer randomShipNumber(Integer bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    @Override
    public String toString() {
        System.out.println(this.armadaName);
        String result = "";
        for (int i = 0; i < armada.size(); i++) {
            result += (i + 1) + ". " + armada.get(i) + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        Armada armada1 = new Armada("GreenFox Armada");
        armada1.fillArmada();
        for (int i = 0; i < armada1.armada.size(); i++) {
            System.out.println(armada1.armada.get(i).toString());
        }
    }
}
