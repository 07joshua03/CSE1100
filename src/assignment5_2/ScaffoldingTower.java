package assignment5_2;

public class ScaffoldingTower extends Equipment{
    public ScaffoldingTower(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "Requirements of scaffolding-tower: " + getRequirements();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScaffoldingTower){
            ScaffoldingTower o = (ScaffoldingTower) obj;
            if(getRequirements() == o.getRequirements()) return true;
        }
        return false;
    }
}
