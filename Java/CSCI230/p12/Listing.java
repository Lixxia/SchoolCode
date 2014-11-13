package p12;

/**
 * @author Laura Barber
 */
public class Listing {
    private String name;
    
    public Listing(String n) {
        name = n;
    }
    
    @Override
    public String toString() {
        return(name);
    }
    
    public Listing deepCopy() {
        return new Listing(name);
    }

}
