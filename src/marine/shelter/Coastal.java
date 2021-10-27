package marine.shelter;

public class Coastal extends Shelter{

    private final int area;

    /**
     * Creates new Coastal Shelter
     * @param ID ID of shelter
     * @param volume Voluem of shelter
     * @param availability Availability of shelter
     * @param area Area of shelter
     */
    public Coastal(String ID, int volume, boolean availability, int area) {
        super(ID, "Coastal", volume, availability, "Cool Eutrophic", "Temperate");
        this.area = area;
    }


    /**
     * Returns area
     * @return Area
     */
    public int getArea() {
        return area;
    }

    /**
     * Returns formatted string of shelter
     * @return Formatted string
     */
    @Override
    public String toString() {
        return getType() + " Shelter\n" + "ID: " + getId() + " - Volume: " + getVolume() + " - Available:" + isAvailabilityString() + " - Land Surface:" + getArea() + "\n";
    }


}
