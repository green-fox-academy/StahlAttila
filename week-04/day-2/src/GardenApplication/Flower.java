package GardenApplication;


public class Flower extends Plant {

    public Flower(String color) {
        super(color);
    }

    @Override
    public Boolean needWater() {
        return this.waterLevel < 5;
    }

    @Override
    public Double getAbsorbRatio() {
        return 0.75;
    }

    @Override
    public String getClassName() {
        return "Flower";
    }
}
