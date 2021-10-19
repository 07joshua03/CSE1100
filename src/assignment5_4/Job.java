package assignment5_4;

import assignment5_1.Address;
import assignment5_2.Equipment;
import assignment5_3.Date;

import java.util.List;
import java.util.Objects;

public class Job {

    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requiredEquipment;
    private Date plannedDate;
    private static int jobTotal = 0;

    public Job(Address location, String description, List<Equipment> requiredEquipment, Date plannedDate) {
        this.location = location;
        this.description = description;
        this.requiredEquipment = requiredEquipment;
        this.plannedDate = plannedDate;

        ++jobTotal;
        jobNumber = jobTotal;
    }

    @Override
    public String toString() {
        StringBuilder eqBuilder = new StringBuilder();
        for(int i = 0; i < requiredEquipment.size(); i++){
            eqBuilder.append(requiredEquipment.get(i).toString());
            if(i != requiredEquipment.size() - 1) eqBuilder.append(", ");
        }

        return "Job number "+ jobNumber + ":\nDescription: " + description + "\nRequired equipment: " + eqBuilder + "\nPlanned date: " + plannedDate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(location, job.location) && Objects.equals(description, job.description) && Objects.equals(requiredEquipment, job.requiredEquipment) && Objects.equals(plannedDate, job.plannedDate);
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public Address getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public static int getJobTotal() {
        return jobTotal;
    }
}
