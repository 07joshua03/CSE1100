package assignment5_2;

import java.util.Objects;

public class ScaffoldingTower extends Equipment{
    public ScaffoldingTower(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "ScaffoldingTower, " + getRequirements() + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScaffoldingTower){
            ScaffoldingTower o = (ScaffoldingTower) obj;
            return Objects.equals(getRequirements(), o.getRequirements());
        }
        return false;
    }
}
