package GardenApplication;

import java.util.ArrayList;

public class Garden {
    protected ArrayList<Plant> garden;

    public Garden() {
        this.garden = new ArrayList<>();
    }

    public void add(Plant plant) {
        this.garden.add(plant);
    }

    public void waterGarden(Double amount) {
        for (Plant plant : garden) {
            if(plant.needWater()){
                plant.watering(waterAmountPerPlants(amount));
            }
        }
    }

    public Double waterAmountPerPlants(Double waterAmount) {
        int counter = 0;
        for (Plant plant : garden) {
            if (plant.needWater()) {
                counter++;
            }
        }
        return waterAmount / counter;
    }

    public void showGarden() {
        for (Plant plant : garden) {
            System.out.println(plant.toString());
        }
    }
}
