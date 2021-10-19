package assignment5_2;

import java.util.Objects;

public class Torch extends Equipment{

    public Torch(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "Requirements of torch: " + getRequirements();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Torch){
            Torch o = (Torch) obj;
            return Objects.equals(getRequirements(), o.getRequirements());
        }
        return false;
    }
}
