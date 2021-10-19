package assignment6_2;

import assignment5_1.Address;
import assignment5_2.*;
import assignment5_3.Date;
import assignment5_4.Job;
import assignment6_1.JobCatalog;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlanningApplication {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        JobCatalog jobCatalog = new JobCatalog();

        System.out.println("Welcome to the planning application!");
        while(!quit){
            System.out.print("1 - Show all jobs in the catalog.\n" +
                    "2 - Add a new job.\n" +
                    "3-6 - To be implemented.\n" +
                    "7 - Quit application.\n\n" +
                    "Please choose an option: ");
            try{
                switch (Integer.parseInt(scanner.next())){
                    case 1:
                        System.out.println(jobCatalog);
                        break;
                    case 2:
                        jobCatalog.getJobs().add(getNewJob(scanner));
                        break;
                    case 7:
                        quit = true;
                        break;
                    default:
                        throw new NotImplementedException();

                }
            }catch (NumberFormatException e) {
                System.out.println("\nPlease input valid option!\n");
            }catch (NotImplementedException e){
                System.out.println("\nThis option is not yet implemented.\nPlease try something else!\n");
            }catch (Exception e){
                System.out.println("Something happened which wasn't supposed to!");
            }

        }

    }


    private static Job getNewJob(Scanner scanner){
        System.out.print("Adding new job! Please give all necessary info:\n\n");
        Address address = getNewAddress(scanner);
        System.out.print("\n\nJob description: ");
        String description = scanner.next();
        List<Equipment> requiredEquipment = getNewRequiredEquipment(scanner);
        Date plannedDate = getNewDate(scanner);

        System.out.print("\n\nJob added! Returning to menu...\n");
        return new Job(address, description, requiredEquipment, plannedDate);
    }

    private static Address getNewAddress(Scanner scanner){
        String street, zipCode, city;
        int number = -1;
        System.out.print("Location:\nStreet: ");
        street = scanner.next();
        while(number == -1){
            try{
                System.out.print("\nStreet number: ");
                number = scanner.nextInt();
            }catch (Exception e){
                System.out.print("\nPlease give valid street number!");
            }
        }
        System.out.print("\nZip code: ");
        zipCode = scanner.next();
        System.out.print("\nCity: ");
        city = scanner.next();

        return new Address(street, number, zipCode, city);
    }

    private static List<Equipment> getNewRequiredEquipment(Scanner scanner){
        boolean quit = false;
        String requirements;
        List<Equipment> requiredEquipment = new ArrayList<>();
        System.out.print("\nAdding equipment: \n\n");
        while(!quit){
            System.out.print("\n1 - ConcreteMixer\n" +
                    "2 - JackHammer\n" +
                    "3 - ScaffoldingTower\n" +
                    "4 - Torch\n" +
                    "exit - Quit application.\n\n" +
                    "Please choose required equipment or type 'exit' to stop adding equipment: ");
            try{
                switch (scanner.next()){
                    case "1":
                        System.out.print("Please give requirements for this equipment: ");
                        requirements = scanner.next();
                        requiredEquipment.add(new ConcreteMixer(requirements));
                        break;
                    case "2":
                        System.out.print("Please give requirements for this equipment: ");
                        requirements = scanner.next();
                        requiredEquipment.add(new JackHammer(requirements));
                        break;
                    case "3":
                        System.out.print("Please give requirements for this equipment: ");
                        requirements = scanner.next();
                        requiredEquipment.add(new ScaffoldingTower(requirements));
                        break;
                    case "4":
                        System.out.print("Please give requirements for this equipment: ");
                        requirements = scanner.next();
                        requiredEquipment.add(new Torch(requirements));
                    case "exit":
                        quit = true;
                        break;
                    default:
                        throw new NotImplementedException();

                }

            }catch (NotImplementedException e){
                System.out.println("\nPlease input valid option!\nPlease try something else!\n");
            }catch (Exception e){
                System.out.println("Something happened which wasn't supposed to!");
            }

        }
        return requiredEquipment;
    }

    private static Date getNewDate(Scanner scanner){
        int day = -1, month = -1, year = -1;
        System.out.print("Adding planned date:\n\n");
        while(day == -1){
            try {
                System.out.print("Day: ");
                day = Integer.parseInt(scanner.next());
            }catch (Exception e){
                System.out.println("Please input valid number! \n");
            }
        }
        while(month == -1){
            try {
                System.out.print("Month: ");
                month = Integer.parseInt(scanner.next());
            }catch (Exception e){
                System.out.println("Please input valid number! \n");
            }
        }
        while(year == -1){
            try {
                System.out.print("Year: ");
                year = Integer.parseInt(scanner.next());
            }catch (Exception e){
                System.out.println("Please input valid number! \n");
            }
        }

        return new Date(day, month, year);
    }

}
