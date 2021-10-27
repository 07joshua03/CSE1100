package marine.shelter;

public abstract class Shelter {

    private final String id;
    private final String type;
    private final int volume;
    private final boolean availability;
    private final String watertype;
    private final String climate;


    /**
     * Creates new Shelter
     * @param ID ID of shelter
     * @param volume Voluem of shelter
     * @param availability Availability of shelter
     * @param watertype Water type of shelter
     */
    public Shelter(String ID, String type, int volume, boolean availability, String watertype, String climate) {
        this.id = ID;
        this.type = type;
        this.volume = volume;
        this.availability = availability;
        this.watertype = watertype;
        this.climate = climate;
    }

    /**
     * Returns type of shelter
     * @return Type of shelter
     */
    public String getType() {
        return type;
    }

    /**
     * Returns ID of shelter
     * @return ID of shelter
     */
    public String getId() {
        return id;
    }

    /**
     * Returns formatted String of availability of shelter
     * @return Formatted string of availability
     */
    public String isAvailabilityString(){
        if(isAvailability()) return "True";
        else return "False";
    }

    /**
     * Returns volume
     * @return Volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns availability
     * @return Availability
     */
    public boolean isAvailability() {
        return availability;
    }

    /**
     * Returns water type
     * @return Water type
     */
    public String getWatertype() {
        return watertype;
    }

    /**
     * Returns climate
     * @return Climate
     */
    public String getClimate() {
        return climate;
    }

    /**
     * Returns boolean of equivalency of this object and provided object
     * @param o Other object
     * @return Equivalency boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return volume == shelter.volume && availability == shelter.availability && id.equals(shelter.id) && watertype.equals(shelter.watertype) && climate.equals(shelter.climate);
    }

    /**
     * Returns formatted string of shelter
     * @return Formatted string
     */
    public abstract String toString();
}
