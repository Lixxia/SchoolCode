package P4;

/**
 * Not really used for p4, leaving it here for reference.
 *
 * @author Laura Barber
 */
public class Stack implements StackI {

    //Initialize errythin'
    private String[] data;
    private int top;
    private int size;

    //no param constructor
    public Stack() {
        top = -1;
        size = 100;
        data = new String[100];
    }

    //param cunstructor
    public Stack(int n) {
        top = -1;
        size = n;
        data = new String[n];
    }

    //push a new element into stack
    public boolean push(Listing newListing) {
        String newNode = newListing.toString();
        boolean returnVal = true;
        if (top == size - 1) {
            returnVal = false;
        } else {
            top++;
            data[top] = newNode;
        }
        return returnVal;
    }

    //pop an element from the stack
    public String pop() {
        int topLocation;
        String returnVal;
        if (top == -1) {
            returnVal = null;
        } else {
            topLocation = top;
            top--;
            returnVal = data[topLocation];
        }
        return returnVal;
    }

    //SHOW ME YOUR CARDS
    public void showAll() {
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i].toString());
        }
    }

    @Override
    public boolean delete(String targetKey) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public Listing fetch(String targetKey) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean insert(Listing newListing) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean update(String targetKey, Listing newListing) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
