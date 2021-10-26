package marine.shelter;

public abstract class Shelter {

    private String id;
    private int volume;
    private boolean availability;
    private String watertype;
    private String climate;

    public Shelter(String ID, int volume, boolean availability, String watertype, String climate) {
        this.id = ID;
        this.volume = volume;
        this.availability = availability;
        this.watertype = watertype;
        this.climate = climate;
    }

    public String getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isAvailability() {
        return availability;
    }

    public String getWatertype() {
        return watertype;
    }

    public String getClimate() {
        return climate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return volume == shelter.volume && availability == shelter.availability && id.equals(shelter.id) && watertype.equals(shelter.watertype) && climate.equals(shelter.climate);
    }

    public abstract String toWrite();

}
