package marine.animals;

import marine.shelter.Shelter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Animal {

    private String name;
    private int requiredVolume;
    private List<Class<? extends Shelter>> shelterPreference;

    public Animal(String name, int requiredVolume, List<Class<? extends Shelter>> shelterPreference) {
        this.name = name;
        this.requiredVolume = requiredVolume;
        this.shelterPreference = shelterPreference;
    }

    public String getName() {
        return name;
    }

    public int getRequiredVolume() {
        return requiredVolume;
    }

    public List<Class<? extends Shelter>> getPossibleShelters() {
        return shelterPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return requiredVolume == animal.requiredVolume && name.equals(animal.name) && shelterPreference.equals(animal.shelterPreference);
    }

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

    public List<Class<? extends Shelter>> getShelterPreference() {
        return shelterPreference;
    }

    public List<Shelter> showAllSuitableShelters(List<Shelter> shelters){
        return shelters.stream().filter(x -> shelterPreference.contains(x.getClass())).collect(Collectors.toList());
    }

}
