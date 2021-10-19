package assignment5_2;

import assignment6_3.PowerSupply;

import java.util.Objects;

public class Torch extends Equipment implements PowerSupply {

    public Torch(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "Torch, " + getPowerSupply() + ", " + getRequirements() + ";";
    }

    public String toWriteString(){
        return "Torch, " +  getRequirements() + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Torch){
            Torch o = (Torch) obj;
            return Objects.equals(getRequirements(), o.getRequirements());
        }
        return false;
    }

    public String getPowerSupply(){
        return "Butane Gas";
    }
}
