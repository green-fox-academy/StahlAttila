package GardenApplication;

public class Plant {
    protected String color;
    protected Double waterLevel;

    public Plant(String color) {
        this.color = color;
        this.waterLevel = 0.;
    }

    public Boolean needWater() {
        return false;
    }

    public void watering(Double waterAmount) {
        this.waterLevel += waterAmount * getAbsorbRatio();
    }

    public Double getAbsorbRatio() {
        return null;
    }

    public String getClassName() {
        return null;
    }

    @Override
    public String toString() {
        if (this.needWater()) {
            return "The " + this.color + " " + this.getClassName() + " needs water. " + this.waterLevel;
        }
        return "The " + this.color + " " + this.getClassName() + " doesn't need water. " + this.waterLevel;
    }
}
