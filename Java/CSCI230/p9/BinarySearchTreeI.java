package p9;

/**
 * Interface for BinarySearchTree
 * @author Laura Barber
 */
public interface BinarySearchTreeI {
    /**
     * @param targetKey
     * @return
     */
    int fetch(int targetKey);

    /**
     * @param newListing
     */
    boolean insert(int newListing);
    
}
