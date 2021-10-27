package marine.shelter;

public class Tundra extends Shelter{

    public Tundra(String ID, int volume, boolean availability) {
        super(ID, "Tundra", volume, availability, "Cool Eutrophic", "Polar");
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getType()).append(" Shelter\n").append("ID: ").append(getId()).append(" - Volume: ").append(getVolume()).append(" - Available:").append(isAvailabilityString()).append("\n");
        return builder.toString();
    }

}
