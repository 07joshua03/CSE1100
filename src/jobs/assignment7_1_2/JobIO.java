package jobs.assignment7_1_2;

import jobs.assignment5_1.Address;
import jobs.assignment5_2.*;
import jobs.assignment5_3.Date;
import jobs.assignment5_4.Job;
import jobs.assignment6_3.PowerSupply;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class JobIO {


    public static List<Job> readJobs(String filename) throws FileNotFoundException{
        List<Job> jobs = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));

        while(scanner.hasNextLine()){
            try{
                String[] addressString = scanner.nextLine().split("; ");

                Address address = new Address(addressString[0], Integer.parseInt(addressString[1]), addressString[2], addressString[3]);
                String description = scanner.nextLine();
                String[] requiredEquipmentString = scanner.nextLine().trim().split(";");

                List<Equipment>  requiredEquipment = new ArrayList<>();
                if(!requiredEquipmentString[0].trim().equals("")) {
                    for (String eq : requiredEquipmentString) {
                        eq = eq.trim();

                        String[] splitEquipment = eq.split(", ");
                        switch (splitEquipment[0]) {
                            case "ConcreteMixer":
                                requiredEquipment.add(new ConcreteMixer(splitEquipment[1]));
                                break;
                            case "JackHammer":
                                requiredEquipment.add(new JackHammer(splitEquipment[1]));
                                break;
                            case "ScaffoldingTower":
                                requiredEquipment.add(new ScaffoldingTower(splitEquipment[1]));
                                break;
                            case "Torch":
                                requiredEquipment.add(new Torch(splitEquipment[1]));
                                break;
                            default:
                                throw new Exception();
                        }
                    }
                }
                String[] plannedDateString = scanner.nextLine().split("-");
                Date plannedDate = new Date(Integer.parseInt(plannedDateString[0]), Integer.parseInt(plannedDateString[1]), Integer.parseInt(plannedDateString[2]));
                jobs.add(new Job(address, description, requiredEquipment, plannedDate));
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Incorrect address formatting in file!");
            }catch (Exception e){
                System.out.println("Formatting error!");
            }

        }
        return jobs;
    }

    public static void writeJobs(List<Job> jobs, String filename){
        try {
            File file = new File(filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < jobs.size(); i++) {
                Job job = jobs.get(i);
                stringBuilder.append(job.getLocation()).append("\n");
                stringBuilder.append(job.getDescription()).append("\n");
                for (Equipment e: job.getRequiredEquipment()){
                    if(e instanceof PowerSupply){
                        stringBuilder.append(e.toString().replace(", " + ((PowerSupply) e).getPowerSupply(), "" ));
                    }else{
                        stringBuilder.append(e);
                    }

                }

//                stringBuilder.append(job.getRequiredEquipment()).append("\n");
                stringBuilder.append("\n").append(job.getPlannedDate());
                if(i < jobs.size() - 1) stringBuilder.append("\n");
            }
            fileOutputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        }catch (FileNotFoundException e){
            System.out.println("File to write to not found!");
        }catch (IOException e){
            System.out.println("Error while writing to file!");
        }

    }

}
