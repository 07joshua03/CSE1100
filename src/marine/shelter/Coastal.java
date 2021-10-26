package marine.shelter;

public class Coastal extends Shelter{

    private int area;

    public Coastal(String ID, int volume, boolean availability, int area) {
        super(ID, volume, availability, "Cool Eutrophic", "Temperate");
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public String toWrite(){
        return "Coastal " + getId() + " " + getVolume() + " " + isAvailability();
    }

}
