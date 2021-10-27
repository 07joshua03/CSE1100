package marine.shelter;

public class Coastal extends Shelter{

    private int area;

    public Coastal(String ID, int volume, boolean availability, int area) {
        super(ID, "Coastal", volume, availability, "Cool Eutrophic", "Temperate");
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getType()).append(" Shelter\n").append("ID: ").append(getId()).append(" - Volume: ").append(getVolume()).append(" - Available:").append(isAvailabilityString()).append(" - Land Surface:").append(getArea()).append("\n");
        return builder.toString();
    }


}
