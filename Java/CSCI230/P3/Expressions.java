package P3;

/**
 *
 * @author Laura Barber
 */
public class Expressions {
    private String operators;
    
    //no param constructor
    public Expressions() {
        operators = "";
    }
    
    //param constructor
    public Expressions(String operators) {
        this.operators = operators;
    }
    
    //converts to string
    @Override
    public String toString() {
        return (operators);
    }
    
    //returns copy
    public Expressions deepCopy() {
        Expressions clone = new Expressions(operators);
        return clone;
    }
    
}
