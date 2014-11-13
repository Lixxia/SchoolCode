package P6;

/**
 *
 * @author Laura Barber
 */
public class PerfectHashed {
    //size of the array
    int size;
    //number of nodes in structure
    int nodes = 0;
    //dummy node
    Listing deleted;
    //primary storage array
    private Listing[] data;
    //closest prime to 60000
    int defaultQuotient = 60013;
    int pass;
    int q;
    int offset;
    int ip;

    //constructor - does not require params
    public PerfectHashed() {
        //subtract 2000 because the ints from 0-1999 are not used
        size = defaultQuotient - 2000;
        data = new Listing[size];
        deleted = new Listing("", "");
        //set every element in array to null
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
    }

    /**
     * Pre-Conditions: newListing Post-Conditions: returns boolean
     */
    public boolean insert(Listing newListing) {
        boolean returnVal;
        boolean hit = false;
        //preprocess key
        int preKey = Integer.parseInt(newListing.getKey());
        pass = 0;
        q = preKey / size;
        offset = q;
        ip = preKey % size;
        if (q % size == 0) {
            offset = defaultQuotient;
        }
        while (pass < size) {
            if (data[ip] == null || data[ip] == deleted) {
                hit = true;
                break;
            }
            ip = (ip + offset) % size;
            pass++;
        }
        if (hit == true) {
            data[ip] = newListing.deepCopy();
            nodes++;
            returnVal = true;
        } else {
            returnVal = false;
        }
        return returnVal;
    }

    /**
     * Pre-Conditions: targetKey Post-Conditions: returns null or deepCopy of
     * desired Listing
     */
    public Listing fetch(String targetKey) {
        Listing returnVal;
        boolean hit = false;
        int preKey = Integer.parseInt(targetKey);
        pass = 0;
        q = preKey / size;
        offset = q;
        ip = preKey % size;
        if (q % size == 0) {
            offset = defaultQuotient;
        }
        while (pass < size) {
            //node not found
            if (data[ip] == null) {
                break;
            }
            //node is found
            if (data[ip].compareTo(targetKey) == 0) {
                hit = true;
                break;
            }
            ip = (ip + offset) % size;
            pass++;
        }
        if (hit == true) {
            returnVal = data[ip].deepCopy();
        } else {
            returnVal = null;
        }
        return returnVal;
    }

    /**
     * Pre-Conditions: targetKey Post-Conditions: returns boolean
     */
    public boolean delete(String targetKey) {
        boolean returnVal;
        boolean hit = false;
        int preKey = Integer.parseInt(targetKey);
        pass = 0;
        q = preKey / size;
        offset = q;
        ip = preKey % size;
        if (q % size == 0) {
            offset = defaultQuotient;
        }
        while (pass < size) {
            //node is not found
            if (data[ip] == null) {
                break;
            }
            //node is found
            if (data[ip].compareTo(targetKey) == 0) {
                hit = true;
                break;
            }
            ip = (ip + offset) % size;
            pass++;
        }
        if (hit == true) {
            data[ip] = deleted;
            nodes--;
            returnVal = true;
        } else {
            returnVal = false;
        }
        return returnVal;
    }

    /**
     * Pre-Conditions: newListing and targetKey Post-Conditions: returns boolean
     */
    public boolean update(String targetKey, Listing newListing) {
        boolean returnVal;
        //tests delete
        if (delete(targetKey) == false) {
            returnVal = false;
        } //tests insert
        else if (insert(newListing) == false) {
            returnVal = false;
        } else {
            returnVal = true;
        }
        return returnVal;
    }

    public void showAll() {
        for (int i = 0; i < size; i++) {
            if (data[i] != null && data[i] != deleted) {
                data[i].toString();
            }
        }
    }
}