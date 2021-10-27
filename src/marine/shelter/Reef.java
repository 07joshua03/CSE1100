package marine.shelter;

public class Reef extends Shelter{

    private int coraltypes;

    public Reef(String ID, int volume, boolean availability, int coraltypes) {
        super(ID, "Reef", volume, availability, "Warm Trophic", "Tropical");
        this.coraltypes = coraltypes;
    }

    public int getCoraltypes() {
        return coraltypes;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getType()).append(" Shelter\n").append("ID: ").append(getId()).append(" - Volume: ").append(getVolume()).append(" - Available: ").append(isAvailabilityString()).append(" - Coral types:").append(getCoraltypes()).append("\n");
        return builder.toString();
    }
}
