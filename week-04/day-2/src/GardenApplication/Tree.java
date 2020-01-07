package GardenApplication;

public class Tree extends Plant {

    public Tree(String color) {
        super(color);
    }

    @Override
    public Boolean needWater() {
        return this.waterLevel < 10;
    }

    @Override
    public Double getAbsorbRatio() {
        return 0.4;
    }

    @Override
    public String getClassName() {
        return "Tree";
    }
}
