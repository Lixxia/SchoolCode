package P3;

/**
 *
 * @author Laura Barber
 */
public class Stack {

    //Initialize errythin'
    private Expressions[] data;
    private int top;
    private int size;
    
    //no param constructor
    public Stack() {
        top = -1;
        size = 100;
        data = new Expressions[100];
    }
    
    //param cunstructor
    public Stack(int n) {
        top = -1;
        size = n;
        data = new Expressions[n];
    }
    
    //push a new element into stack
    public boolean push(Expressions newNode) {
        boolean returnVal = true;
        if(top == size -1) {
            returnVal = false;
        }
        else {
            top++;
            data[top] = newNode.deepCopy();
        }
        return returnVal;
    }
    
    //pop an element from the stack
    public Expressions pop() {
        //Not sure how to avoid using two return statements at this point,
        //since null and data[topLocation] are of different types.
        int topLocation;
        if(top==-1) {
            return null;
        }
        else {
            topLocation = top;
            top--;
            return data[topLocation];
        }
    }
    
    //SHOW ME YOUR CARDS
    public void showAll() {
        for(int i=top; i >= 0; i--){
        System.out.println(data[i].toString());
    }
    }
    
    
}
