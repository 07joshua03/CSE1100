package marine.shelter;

public class Tundra extends Shelter{

    /**
     * Creates new Tundra Shelter
     * @param ID ID of shelter
     * @param volume Voluem of shelter
     * @param availability Availability of shelter
     */
    public Tundra(String ID, int volume, boolean availability) {
        super(ID, "Tundra", volume, availability, "Cool Eutrophic", "Polar");
    }

    /**
     * Returns formatted string of shelter
     * @return Formatted string
     */
    public String toString() {
        return getType() + " Shelter\n" + "ID: " + getId() + " - Volume: " + getVolume() + " - Available:" + isAvailabilityString() + "\n";
    }

}
