package p5;

/**
 *
 * @author Laura Barber
 */
public class GenericQueue<T> implements GenericQueueInterface<T> {
    //initializing all elements

    private T[] data;
    private int size;
    private int numOfNodes;
    private int front;
    private int rear;

    //no param constructor
    public GenericQueue() {
        this(100);
    }
    //param constructor

    public GenericQueue(int size) {
        this.numOfNodes = 0;
        this.front = 0;
        this.rear = 0;
        this.data = (T[]) new Object[size];
    }

    @Override
    //adds an element to the rear of the queue
    public boolean enque(T element) {
        boolean returnVal;
        //check for overflow
        if (numOfNodes == size) {
            returnVal = false;
        } else {
            numOfNodes++;
            data[rear] = element;
            rear = (rear + 1) % size;
            returnVal = true;
        }
        return returnVal;
    }

    @Override
    //removes an element from the front of a queue
    public T deque() {
        T returnVal = null;
        int frontLocation;
        //check for underflow
        if (numOfNodes == size) {
            returnVal = null;
        } else {
            frontLocation = front;
            front = (front + 1) % size;
            numOfNodes--;
            returnVal = data[frontLocation];
        }
        return returnVal;
    }

    @Override
    //prints all elements in the queue
    public void showAll() {
        int f = front;
        for (int i = 1; i <= numOfNodes; i++) {
            System.out.println(data[i].toString());
            f = (f + 1) % size;
        }
    }
}
