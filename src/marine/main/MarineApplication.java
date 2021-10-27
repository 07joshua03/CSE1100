package marine.main;

import marine.animals.Animal;
import marine.io.MarineIO;
import marine.shelter.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MarineApplication {

    /**
     * Main function
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Marine Program!");
        Scanner scanner = new Scanner("res/shelters.txt\nres/animals.txt\n");
        List<Shelter> shelters = MarineIO.readShelterFile(scanner);
        List<Animal> animals = MarineIO.readAnimalFile(scanner);
        scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.print("\n\n1 – Show all shelters\n" +
                    "2 – Show all animals\n" +
                    "3 – Show all shelters suitable for a specific animal\n" +
                    "4 – Show the optimal shelters for a specific animal\n" +
                    "5 – Show the constant properties per shelter type\n" +
                    "6 – Stop the program\n" +
                    "Please make your choice: ");
            switch (scanner.next()){
                case "1":
                    System.out.print("\n");
                   for(Shelter s : shelters) System.out.print(s);
                    break;
                case "2":
                    System.out.print("\n");
                    for(Animal a : animals) System.out.print(a);
                    break;
                case "3":
                    System.out.print("\n");
                    for(Shelter s : showSuitableSheltersForAnimal(scanner, animals, shelters)) System.out.print(s);
                    break;
                case "4":
                    System.out.print("\n");
                    for(Shelter s : showOptimalSheltersForAnimal(scanner, animals, shelters)) System.out.print(s);
                    break;
                case "5":
                    Shelter shelter = showShelterProperties(scanner);
                    System.out.print("\n" + shelter.getClimate() + " - " + shelter.getWatertype());
                    break;
                case "6":
                    quit = true;
                    break;
                default:
                    System.out.println("\nPlease give valid option");
            }
        }
        System.out.println("Exiting program...");

    }


    /**
     * Returns list of shelters suitable for animal provided by user input
     * @param scanner Scanner currently in use by application
     * @param animals List of all animals loaded by program
     * @param shelters List of all shelters loaded by program
     * @return List of shelters suitable for animal
     */
    public static List<Shelter> showSuitableSheltersForAnimal(Scanner scanner, List<Animal> animals, List<Shelter> shelters){
        Animal animal = getAnimalFromInput(scanner, animals);
        return animal.showAllSuitableShelters(shelters);
    }

    /**
     * Returns ordered list of optimal shelters for animal provided by user input
     * @param scanner Scanner currently in use by application
     * @param animals List of all animals loaded by program
     * @param shelters List of all shelters loaded by program
     * @return List of shelters optimal for animal
     */
    public static List<Shelter> showOptimalSheltersForAnimal(Scanner scanner, List<Animal> animals, List<Shelter> shelters){
        Animal animal = getAnimalFromInput(scanner, animals);
        List<Shelter> animalShelters = animal.showAllSuitableShelters(shelters);
        return animalShelters.stream().filter(Shelter::isAvailability).sorted(new ShelterVolumeComparator()).sorted(new ShelterPreferenceComparator(animal)).collect(Collectors.toList());
    }

    /**
     * Returns animal provided by user input
     * @param scanner Scanner currently in use by application
     * @param animals List of all animals loaded by program
     * @return Animal
     */
    public static Animal getAnimalFromInput(Scanner scanner, List<Animal> animals){
        boolean animalFound = false;
        Animal animal = null;
        while(!animalFound){
            System.out.print("Please give an animal: ");
            StringBuilder input = new StringBuilder();
            input.append(scanner.next());
            //while(scanner.hasNextByte()) input.append(scanner.nextByte());
            for(int i = 0; i < animals.size(); i++){
                if(animals.get(i).getName().equals(input.toString())){
                    animalFound = true;
                    animal = animals.get(i);
                    break;
                }else if (i == animals.size() - 1) System.out.println("\nPlease give valid animal!");
            }
        }
        return animal;
    }

    /**
     * Returns a shelter which holds properties of shelter provided by user input
     * @param scanner Scanner currently in use by application
     * @return Shelter which holds properties of shelter
     */
    public static Shelter showShelterProperties(Scanner scanner){
        boolean shelterFound = false;
        Shelter shelter = null;
        while(!shelterFound){
            System.out.print("Please give a shelter type: ");
            switch (scanner.next()){
                case "Tundra":
                    shelter = new Tundra("", 0, false);
                    shelterFound = true;
                    break;
                case "Coastal":
                    shelter = new Coastal("", 0, false, 0);
                    shelterFound = true;
                    break;
                case "Reef":
                    shelter = new Reef("", 0, false, 0);
                    shelterFound = true;
                    break;
                default:
                    System.out.println("Please provide valid shelter type!");

            }
        }
        return shelter;
    }
}
