package marine.animals;

import marine.shelter.Shelter;

import java.util.List;
import java.util.stream.Collectors;

public class Animal {

    private final String name;
    private final int requiredVolume;
    private final List<Class<? extends Shelter>> shelterPreference;

    /**
     * Creates new Animal
     * @param name Name of animal
     * @param requiredVolume Required volume of animal
     * @param shelterPreference List of preferred shelters in order
     */
    public Animal(String name, int requiredVolume, List<Class<? extends Shelter>> shelterPreference) {
        this.name = name;
        this.requiredVolume = requiredVolume;
        this.shelterPreference = shelterPreference;
    }

    /**
     * Returns name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns required volume
     * @return Required volume
     */
    public int getRequiredVolume() {
        return requiredVolume;
    }

    /**
     * Compares this to object
     * @param o Object to compare
     * @return boolean of equivalence
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return requiredVolume == animal.requiredVolume && name.equals(animal.name) && shelterPreference.equals(animal.shelterPreference);
    }

    /**
     * Creates string for animal
     * @return Formatted string of animal
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getName()).append(" - Requires: ").append(getRequiredVolume()).append(" m3 - Preferred Shelter: ");
        for(int i = 0; i < shelterPreference.size(); i++){
            if(i != 0) builder.append(", ");
            builder.append(shelterPreference.get(i).getSimpleName());
        }
        return builder.append("\n").toString();
    }

    /**
     * Returns list of shelter preference
     * @return list of shelter preference
     */
    public List<Class<? extends Shelter>> getShelterPreference() {
        return shelterPreference;
    }


    /**
     * Returns all suitable shelters from shelter list
     * @param shelters List of all shelters
     * @return shelters which are suitable for animal
     */
    public List<Shelter> showAllSuitableShelters(List<Shelter> shelters){
        return shelters.stream().filter(x -> shelterPreference.contains(x.getClass())).collect(Collectors.toList());
    }

}
