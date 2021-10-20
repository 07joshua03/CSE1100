package assignment5_2;

import java.util.Objects;

public class ConcreteMixer extends Equipment{
    public ConcreteMixer(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "ConcreteMixer, " + getRequirements() + "; ";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConcreteMixer){
            ConcreteMixer o = (ConcreteMixer) obj;
            return Objects.equals(getRequirements(), o.getRequirements());
        }
        return false;
    }
}
