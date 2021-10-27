package marine.shelter;

import marine.animals.Animal;

import java.util.Comparator;

public class ShelterPreferenceComparator implements Comparator<Shelter> {

    private final Animal animal;

    /**
     * Creates Shelter Preference Comparator
     * @param animal Animal which provides preference ordering
     */
    public ShelterPreferenceComparator(Animal animal){
        this.animal = animal;
    }

    /**
     * Compares two shelters and returns the integer compare value
     * @param o1 Shelter one to compare
     * @param o2 Shelter two to compare
     * @return Integer compare value
     */
    @Override
    public int compare(Shelter o1, Shelter o2) {
        int i = 0, j = 0;
        for(int k = 0; k < animal.getShelterPreference().size(); k++){
            if(o1.getClass().equals(animal.getShelterPreference().get(k))) i = k;
            if(o2.getClass().equals(animal.getShelterPreference().get(k))) j = k;
        }
        return Integer.compare(i, j);
    }
}
