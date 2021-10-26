package marine.animals;

import marine.shelter.Shelter;

import java.util.List;
import java.util.Objects;

public class Animal {

    private String name;
    private int requiredVolume;
    private List<Shelter> possibleShelters;

    public Animal(String name, int requiredVolume, List<Shelter> possibleShelters) {
        this.name = name;
        this.requiredVolume = requiredVolume;
        this.possibleShelters = possibleShelters;
    }

    public String getName() {
        return name;
    }

    public int getRequiredVolume() {
        return requiredVolume;
    }

    public List<Shelter> getPossibleShelters() {
        return possibleShelters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return requiredVolume == animal.requiredVolume && name.equals(animal.name) && possibleShelters.equals(animal.possibleShelters);
    }

}
