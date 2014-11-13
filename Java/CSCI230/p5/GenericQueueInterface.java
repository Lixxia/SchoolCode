package p5;

/**
 *
 * @author Laura Barber
 */
public interface GenericQueueInterface<T> {

    T deque();

    boolean enque(T element);

    void showAll();
}
