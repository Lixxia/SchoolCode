package P4;

/**
 *
 * @author Laura Barber
 */
class Listing {

    private String operators;

    //no param constructor
    public Listing() {
        operators = "";
    }

    //param constructor
    public Listing(String operators) {
        this.operators = operators;
    }

    //converts to string
    @Override
    public String toString() {
        return (operators);
    }

    //returns copy
    public Listing deepCopy() {
        Listing clone = new Listing(operators);
        return clone;
    }

    //compares
    public int compareTo(String targetKey) {
        return operators.compareTo(targetKey);
    }
}
