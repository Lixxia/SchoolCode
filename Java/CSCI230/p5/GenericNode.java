/**
 * Referenced from Dr. Bowring's code example.
 */
package p5;

/**
 *
 * @author Laura Barber
 */
public class GenericNode<T> {
    //initializes values

    private T contents;
    private GenericNode next;

    //node constructor
    public GenericNode() {
        this.contents = null;
        this.next = null;
    }

    //returns contents of node
    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }

    public GenericNode getNext() {
        return next;
    }

    public void setNext(GenericNode next) {
        this.next = next;
    }

    public String showContents() {
        return contents.toString();
    }
}
