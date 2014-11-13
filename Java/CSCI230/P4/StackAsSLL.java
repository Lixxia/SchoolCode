package P4;

/**
 *
 * @author Laura Barber
 */
public class StackAsSLL implements StackI {

    public class Node {

        private Listing l;
        private Node next;

        public Node() {
        }
    }
    private String targetKey;
    private Node h;

    public StackAsSLL() {
        h = new Node();
        h.l = null;
        h.next = null;
    }

    /**
     *
     * @param newListing
     * @return boolean
     */
    @Override
    public boolean insert(Listing newListing) {
        Node n = new Node();
        boolean returnVal;
        //check if memory left
        if (n == null) {
            returnVal = false;
        } else {
            n.next = h.next;
            h.next = n;
            n.l = newListing.deepCopy();
            returnVal = true;
        }
        return returnVal;
    }

    @Override
    public boolean push(Listing newListing) {
        return insert(newListing);
    }

    /**
     * Not used in this implementation.
     *
     * @param targetKey
     * @return Listing
     */
    @Override
    public Listing fetch(String targetKey) {
        Listing returnVal;
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)) {
            p = p.next;
        }
        if (p != null) {
            returnVal = p.l.deepCopy();
        } else {
            returnVal = null;
        }
        return returnVal;
    }

    //Not used in this implementation.
    @Override
    public boolean delete(String targetKey) {
        boolean returnVal;
        Node q = h;
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)) {
            q = p;
            p = p.next;
        }
        if (p != null) {
            q.next = p.next;
            returnVal = true;
        } else {
            returnVal = false;
        }
        return returnVal;
    }

    public String pop() {
        String returnVal;
        //check if list is empty
        if (h.next == null) {
            returnVal = null;
        } else {
            Listing p = h.next.l;
            h.next = h.next.next;
            returnVal = p.deepCopy().toString();
        }
        return returnVal;
    }

    /**
     *
     * @param targetKey
     * @param newListing
     * @return boolean
     */
    @Override
    public boolean update(String targetKey, Listing newListing) {
        boolean returnVal;
        if (delete(targetKey) == false) {
            returnVal = false;
        } else if (insert(newListing) == false) {
            returnVal = false;
        } else {
            returnVal = true;
        }
        return returnVal;
    }

    @Override
    public void showAll() {
        Node p = h.next;
        while (p != null) {
            System.out.println(p.l.toString());
            p = p.next;
        }
    }
}
