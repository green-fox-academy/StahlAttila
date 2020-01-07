package GardenApplication;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class Main {
    public static void main(String[] args) {

        Plant yellow = new Flower("yellow");
        Plant blue = new Flower("blue");
        Plant purple = new Tree("purple");
        Plant orange = new Tree("orange");

        Garden garden = new Garden();
        garden.add(yellow);
        garden.add(blue);
        garden.add(purple);
        garden.add(orange);

        garden.showGarden();
        System.out.println("------------------------");
        garden.waterGarden(40.);
        garden.showGarden();
        System.out.println("------------------------");
        garden.waterGarden(70.);
        garden.showGarden();
    }
}
