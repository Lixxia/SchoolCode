package P4;

/**
 *
 * @author Laura Barber
 */
public interface StackI {

    boolean delete(String targetKey);

    /**
     *
     * @param targetKey
     * @return Listing
     */
    Listing fetch(String targetKey);

    /**
     *
     * @param newListing
     * @return boolean
     */
    boolean insert(Listing newListing);

    String pop();

    boolean push(Listing newListing);

    void showAll();

    /**
     *
     * @param targetKey
     * @param newListing
     * @return boolean
     */
    boolean update(String targetKey, Listing newListing);
}
