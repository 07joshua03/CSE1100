package marine.shelter;

public class Reef extends Shelter{

    private int coraltypes;

    public Reef(String ID, int volume, boolean availability, int coraltypes) {
        super(ID, volume, availability, "Warm Trophic", "Tropical");
        this.coraltypes = coraltypes;
    }

    public int getCoraltypes() {
        return coraltypes;
    }
}
