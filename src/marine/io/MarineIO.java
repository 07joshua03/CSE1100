package marine.io;

import marine.animals.Animal;
import marine.shelter.Coastal;
import marine.shelter.Reef;
import marine.shelter.Shelter;
import marine.shelter.Tundra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarineIO {

    /**
     * Returns list of shelters from user inputted file
     * @param scanner current scanner which is in use by application
     * @return list of shelters from user inputted file
     * @throws IllegalArgumentException when file is formatted wrong
     */
    public static List<Shelter> readShelterFile(Scanner scanner) throws IllegalArgumentException {
        boolean fileFound = false;
        Scanner fileScanner = null;
        List<Shelter> shelters = new ArrayList<>();
        while(!fileFound){
            try {
                System.out.print("Please give shelter file: ");
                fileScanner = new Scanner(new File(scanner.next()));
                if(fileScanner.hasNextLine()) fileFound = true;
                else System.out.println("Please give valid file!");
            }catch (FileNotFoundException e){
                System.out.println("Please give valid file!");
            }
        }
        while(fileScanner.hasNextLine()){
            String[] nextArgs = fileScanner.nextLine().split(" ");
            switch (nextArgs[0]){
                case "Coastal":
                    shelters.add(new Coastal(nextArgs[1], Integer.parseInt(nextArgs[2]), Boolean.parseBoolean(nextArgs[3]), Integer.parseInt(nextArgs[4])));
                    break;
                case "Tundra":
                    shelters.add(new Tundra(nextArgs[1], Integer.parseInt(nextArgs[2]), Boolean.parseBoolean(nextArgs[3])));

                    break;
                case "Reef":
                    shelters.add(new Reef(nextArgs[1], Integer.parseInt(nextArgs[2]), Boolean.parseBoolean(nextArgs[3]), Integer.parseInt(nextArgs[4])));
                    break;
                default:
                    throw new IllegalArgumentException();
            }

        }

        return shelters;
    }


    /**
     * Returns list of animals from user inputted file
     * @param scanner current scanner which is in use by application
     * @return list of animals from user inputted file
     * @throws IllegalArgumentException when file is formatted wrong
     */
    public static List<Animal> readAnimalFile(Scanner scanner) throws IllegalArgumentException {
        boolean fileFound = false;
        Scanner fileScanner = null;
        List<Animal> animals = new ArrayList<>();
        while(!fileFound){
            try {
                System.out.print("Please give animals file: ");
                fileScanner = new Scanner(new File(scanner.next()));
                if(fileScanner.hasNextLine()) fileFound = true;
                else System.out.println("Please give valid file!");
            }catch (FileNotFoundException e){
                System.out.println("Please give valid file!");
            }
        }

        while(fileScanner.hasNextLine()){
            String[] nextArgs = fileScanner.nextLine().split("; ");
            List<Class<? extends Shelter>> shelterPreference = new ArrayList<>();
            for(String s : nextArgs[2].split(", ")){
                switch (s.trim()){
                    case "Tundra":
                        shelterPreference.add(Tundra.class);
                        break;
                    case "Coastal":
                        shelterPreference.add(Coastal.class);
                        break;
                    case "Reef":
                        shelterPreference.add(Reef.class);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }

            }
            animals.add(new Animal(nextArgs[0], Integer.parseInt(nextArgs[1]), shelterPreference));
        }

        return animals;
    }


}
