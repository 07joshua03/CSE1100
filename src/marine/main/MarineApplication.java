package marine.main;

import marine.animals.Animal;
import marine.io.MarineIO;
import marine.shelter.Shelter;
import marine.shelter.Tundra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarineApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to the Marine Program!");
        Scanner scanner = new Scanner(System.in);
        List<Shelter> shelters = MarineIO.readShelterFile(scanner);
        List<Animal> animals = MarineIO.readAnimalFile(scanner);

        boolean quit = false;
        while(!quit){
            System.out.print("\n1 – Show all shelters\n" +
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

                    for(Shelter s : animals.get(0).showAllSuitableShelters(shelters)) System.out.print(s);
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                default:
                    System.out.println("\nPlease give valid option");
            }
        }

    }


}
