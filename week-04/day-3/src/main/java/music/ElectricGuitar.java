package main.java.music;

public class ElectricGuitar extends StringedInstrument{

    public ElectricGuitar() {
        super.name = "Electric Guitar";
        super.numberOfStrings = 6;
    }

    public ElectricGuitar(Integer numberOfStrings) {
        super.name = "Electric Guitar";
        super.numberOfStrings = numberOfStrings;
    }

    @Override
    public String sound() {
        return "Twang";
    }
}
