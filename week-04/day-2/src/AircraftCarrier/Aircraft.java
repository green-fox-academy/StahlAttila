package AircraftCarrier;

public class Aircraft {
    protected String type;
    protected Integer baseDmg;
    protected Integer ammo;
    protected Integer maxAmmo;

    public Aircraft(Integer baseDmg, Integer maxAmmo) {
        this.baseDmg = baseDmg;
        this.maxAmmo = maxAmmo;
        this.ammo = 0;
    }
}
