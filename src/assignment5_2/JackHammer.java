package assignment5_2;

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
            if(getRequirements() == o.getRequirements()) return true;
        }
        return false;
    }
}
