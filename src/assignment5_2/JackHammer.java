package assignment5_2;

import java.util.Objects;

public class JackHammer extends Equipment{
    public JackHammer(String requirements) {
        super(requirements);
    }

    @Override
    public String toString() {
        return "Requirements of jack-hammer: " + getRequirements();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JackHammer){
            JackHammer o = (JackHammer) obj;
            return Objects.equals(getRequirements(), o.getRequirements());
        }
        return false;
    }
}
