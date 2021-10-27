package marine.shelter;

import java.util.Comparator;

public class ShelterVolumeComparator implements Comparator<Shelter> {

    /**
     * Returns integer compare value of volume
     * @param o1 First shelter to compare volume of
     * @param o2 Second shelter to compare volume of
     * @return Value of volume comparison
     */
    @Override
    public int compare(Shelter o1, Shelter o2) {
        return Integer.compare(o1.getVolume(), o2.getVolume());
    }
}
