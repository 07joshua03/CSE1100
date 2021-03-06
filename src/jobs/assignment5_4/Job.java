package jobs.assignment5_4;

import jobs.assignment5_1.Address;
import jobs.assignment5_2.Equipment;
import jobs.assignment5_3.Date;

import java.util.List;
import java.util.Objects;

public class Job {

    private final int jobNumber;
    private final Address location;
    private final String description;
    private final List<Equipment> requiredEquipment;
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



        return "Job number "+ jobNumber + ":\nLocation: " + location + "\nDescription: " + description + "\nRequired equipment: " + eqBuilder + "\nPlanned date: " + plannedDate.toString();
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

    public void setPlannedDate(Date date){
        this.plannedDate = date;
    }
}
