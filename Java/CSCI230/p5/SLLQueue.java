package p5;

/**
 *
 * @author Laura Barber
 */
public class SLLQueue<T> implements GenericQueueInterface<T> {
    //initalizes header node

    private GenericNode h;

    //creates new header node
    public SLLQueue() {
        h = new GenericNode();

    }

    /**
     * Having trouble with enque/deque. One or the other needs to change in
     * order to remove or add elements in the correct order for a queue.
     *
     * If change deque: would need to have a rear and take the element off from
     * there instead of being taken out of the front node.
     *
     * If change enque: would need to figure out how to push the previous
     * element forward and put the new element into the first position, right
     * now it's just inserting in the order there were enqued in.
     */
    @Override
    //adds an element to the queue using a SLL
    public boolean enque(T element) {
        boolean returnVal = false;
        GenericNode node = new GenericNode();

        if (node != null) {
            node.setNext(h.getNext());
            h.setNext(node);
            node.setContents(element);
            returnVal = true;
        }
        return returnVal;
    }

    @Override
    //removes an element from the queue using a SLL
    public T deque() {
        T returnVal = null;

        GenericNode dequeued = h.getNext();
        if (dequeued != null) {
            returnVal = (T) dequeued.getContents();
            h.setNext(dequeued.getNext());
        }
        return returnVal;
    }

    //checks if SLL is empty
    public boolean empty() {
        return h.getNext() == null;
    }

    @Override
    //prints all elements in the queue
    public void showAll() {
        GenericNode pNode = h.getNext();
        while (pNode != null) {
            System.out.println(pNode.showContents());
            pNode = pNode.getNext();
        }
    }
}
