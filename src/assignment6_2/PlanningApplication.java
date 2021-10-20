package assignment6_2;

import assignment5_1.Address;
import assignment5_2.*;
import assignment5_3.Date;
import assignment5_4.Job;
import assignment6_1.JobCatalog;
import assignment7_1_2.JobIO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class PlanningApplication {

    private static final String jobsFile = "res/jobslist.txt";

    public static void main(String[] args) {
        boolean quit = false;
        JobCatalog jobCatalog = new JobCatalog();

        Scanner scanner = new Scanner(System.in);
        try{
            jobCatalog.setJobs(JobIO.readJobs(jobsFile));
        } catch (FileNotFoundException e){
            System.out.println("Critical error: File not found!");
            quit = true;
        }


        System.out.println("Welcome to the planning application!");
        while(!quit){
            System.out.print("1 - Show all jobs in the catalog.\n" +
                    "2 - Add a new job.\n" +
                    "3 - Delete existing job.\n" +
                    "4 - Change date of existing job.\n" +
                    "5 - Print jobs by date.\n" +
                    "6 - Print required materials by date.\n" +
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
                    case 3:
                        deleteJob(scanner, jobCatalog);
                        break;
                    case 4:
                        changeDate(scanner, jobCatalog);
                        break;
                    case 5:
                        Stream<Job> jobsFromDate = getJobsFromDate(scanner, jobCatalog);
                        if(jobsFromDate != null) jobsFromDate.forEach(System.out::println);
                        break;
                    case 6:
                        Stream<Job> jobsForReqMats = getJobsFromDate(scanner, jobCatalog);
                        assert jobsForReqMats != null;
                        printMaterials(jobsForReqMats);
                        break;
                    case 7:
                        quit = true;
                        JobIO.writeJobs(jobCatalog.getJobs(), jobsFile);
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
                        break;
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

    private static void deleteJob(Scanner scanner, JobCatalog jobCatalog){
        boolean wantToDelete = true;
        while(wantToDelete){
            try{
                System.out.println(jobCatalog);
                System.out.print("\nPlease choose a job to delete, \nor type 0 to go back: ");
                int input = Integer.parseInt(scanner.next());
                if(input == 0) wantToDelete = false;
                else{
                    for(int i = 0; i < jobCatalog.getJobs().size(); i++){
                        if(jobCatalog.getJobs().get(i).getJobNumber() == input){
                            System.out.print("Are you sure (y/N)? ");
                            boolean sure = false;
                            while(!sure) {
                                switch (scanner.next()){
                                    case "y":
                                        jobCatalog.getJobs().remove(i);
                                        sure = true;
                                        System.out.println("\nJob deleted!\n");
                                        break;
                                    case "n":
                                    case "":
                                        sure = true;
                                        break;
                                    default:
                                        System.out.println("\nPlease give a valid option!");
                                }
                            }
                            break;
                        }
                        if(i == jobCatalog.getJobs().size() - 1) throw new FileNotFoundException();
                    }

                }
            }catch (NumberFormatException e){
                System.out.println("Please give a valid number!");
            }catch (FileNotFoundException e){
                System.out.println("Job doesn't exist! Please provide a valid job!");
            }
        }

    }

    private static void changeDate(Scanner scanner, JobCatalog jobCatalog){
        boolean wantToChangeDate = true;
        while(wantToChangeDate){
            try{
                System.out.println(jobCatalog);
                System.out.print("\nPlease choose a job number to change date of, \nor type 0 to go back: ");
                int input = Integer.parseInt(scanner.next());
                if(input == 0) wantToChangeDate = false;
                else{
                    for(int i = 0; i < jobCatalog.getJobs().size(); i++){
                        if(jobCatalog.getJobs().get(i).getJobNumber() == input){
                            System.out.print("\nDay: ");
                            int day = Integer.parseInt(scanner.next());
                            System.out.print("Month: ");
                            int month = Integer.parseInt(scanner.next());
                            System.out.print("Year: ");
                            int year = Integer.parseInt(scanner.next());
                            jobCatalog.getJobs().get(i).setPlannedDate(new Date(day, month, year));
                            break;
                        }
                        if(i == jobCatalog.getJobs().size() - 1) throw new FileNotFoundException();
                    }

                }
            }catch (NumberFormatException e){
                System.out.println("Please give a valid number!");
            }catch (FileNotFoundException e){
                System.out.println("Job doesn't exist! Please provide a valid job!");
            }
        }
    }

    private static Stream<Job> getJobsFromDate(Scanner scanner, JobCatalog jobCatalog){
        try {
            System.out.println("Please provide the date of job(s):\n");
            System.out.print("Day: ");
            int day = Integer.parseInt(scanner.next());
            System.out.print("Month: ");
            int month = Integer.parseInt(scanner.next());
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.next());
            Stream<Job> jobStream = jobCatalog.getJobs().stream();

            return jobStream.filter(x -> x.getPlannedDate().equals(new Date(day, month, year)));
        }catch (NumberFormatException e){
            System.out.println("PLease input valid number!");
        }catch (Exception e){
            System.out.println("Error! Please try again!");
        }
        return null;
    }

    private static void printMaterials(Stream<Job> jobStream){
        List<Equipment> equipmentList = new ArrayList<>();
        jobStream.forEach(x -> equipmentList.addAll(x.getRequiredEquipment()));
        equipmentList.stream().distinct().forEach(System.out::println);
    }
}
