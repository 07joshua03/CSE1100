package marine.shelter;

public class Reef extends Shelter{

    private final int coraltypes;

    /**
     * Creates new Reef Shelter
     * @param ID ID of shelter
     * @param volume Voluem of shelter
     * @param availability Availability of shelter
     * @param coraltypes Amount of coral types of shelter
     */
    public Reef(String ID, int volume, boolean availability, int coraltypes) {
        super(ID, "Reef", volume, availability, "Warm Trophic", "Tropical");
        this.coraltypes = coraltypes;
    }

    /**
     * Returns amount of coral types
     * @return Amount of coral types
     */
    public int getCoraltypes() {
        return coraltypes;
    }

    /**
     * Returns formatted string of shelter
     * @return Formatted string
     */
    public String toString() {
        return getType() + " Shelter\n" + "ID: " + getId() + " - Volume: " + getVolume() + " - Available: " + isAvailabilityString() + " - Coral types:" + getCoraltypes() + "\n";
    }
}
