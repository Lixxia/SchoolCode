package P6;

/**
 *
 * @author Laura Barber
 */
public class Listing {

    /**
     * Pre-Conditions: Name must be in the format FirstName LastName, please
     * note that there is a space between the two elements.
     */
    private String ticketNum;
    private String name;

    //no param constructor
    public Listing() {
        ticketNum = "";
        name = "";
    }
    //constructur accepting params

    public Listing(String ticketNum, String name) {
        this.ticketNum = ticketNum;
        this.name = name;
    }

    public String toString() {
        return ("Name is " + name
                + "\nTicket Number is " + ticketNum);
    }

    public Listing deepCopy() {
        return new Listing(ticketNum, name);
    }

    public int compareTo(String targetKey) {
        return (ticketNum.compareTo(targetKey));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return ticketNum;
    }
}
