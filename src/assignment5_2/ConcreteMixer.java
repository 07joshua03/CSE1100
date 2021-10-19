package assignment5_2;

public class ConcreteMixer extends Equipment{
    public ConcreteMixer(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "Requirements of concrete-mixer: " + getRequirements();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConcreteMixer){
            ConcreteMixer o = (ConcreteMixer) obj;
            if(getRequirements() == o.getRequirements()) return true;
        }
        return false;
    }
}
