package assignment5_2;

import assignment6_3.PowerSupply;

import java.util.Objects;

public class JackHammer extends Equipment implements PowerSupply {
    public JackHammer(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "JackHammer, " +   getRequirements() + ", " + getPowerSupply() +  "; ";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JackHammer){
            JackHammer o = (JackHammer) obj;
            return Objects.equals(getRequirements(), o.getRequirements());
        }
        return false;
    }

    public String getPowerSupply(){
        return "Air Compressor";
    }
}
