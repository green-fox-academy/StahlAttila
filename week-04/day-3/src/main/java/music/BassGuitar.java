package main.java.music;

public class BassGuitar extends StringedInstrument{

    public BassGuitar() {
        super.name = "Bass Guitar";
        super.numberOfStrings = 4;
    }

    public BassGuitar(Integer numberOfStrings) {
        super.name = "Bass Guitar";
        super.numberOfStrings = numberOfStrings;
    }

    @Override
    public String sound() {
        return "Duum-duum-duum";
    }
}
