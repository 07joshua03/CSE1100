package assignment5_2;

public abstract class Equipment {

    private String requirements;

    public Equipment(String requirements){
        this.requirements = requirements;
    }

    public String getRequirements() {
        return requirements;
    }
}
