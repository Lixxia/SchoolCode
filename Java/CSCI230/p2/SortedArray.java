package p2;

/**
 *
 * @author Laura Barber
 */
public class SortedArray {
    private int next;
    private int size;
    private StudentListings[] data;
   
    private String targetKey;
    
    //size determined by user
    public SortedArray(int s) {
        next = 0;
        data = new StudentListings[s];
        size = s;
    }
    
    //no-param
    public SortedArray() {
        next = 0;
        size = 20;
        data = new StudentListings[size];
    }
    
    //gets length of array
    public int getLength() {
        return size;
    }
    
    //Binary Search, returns -1 if failed to find.
    public static int binarySearch(StudentListings[] data, String targetKey) {
        int first = 0;
        int last = data.length;
        int returnValue;
        
        while (first < last) {
            int mid = (first + last) / 2;
            if (data[mid].compareTo(targetKey) < 0) {
                // repeat search bottom half.
                first = last;                
            }
            else if (data[mid].compareTo(targetKey) > 0) {
                // repeat search top half
                first = mid + 1;                
            }
            else {
                returnValue = mid;
            }
        }
        returnValue = -(first + 1);
        return returnValue;
    }
    //fetch
    public StudentListings fetch(String targetKey) {
        return data[binarySearch(data, targetKey)].deepCopy();        
    }
    //delete
    public boolean delete(String targetKey) {
        int i = binarySearch(data, targetKey);
        boolean returnValue; 
        //node not found
        if(i == next) {
           returnValue = false; 
        }
        else {
           returnValue= true;
        }
        for(int j=i; j < next -1;j++) {
            data[j] = data[j+1];
        }
        next--;
        data[next]=null;
        
        return returnValue;
    }
    //update
    public boolean update(String targetKey, StudentListings newListing) {
        boolean returnValue;
        //deleting failed
        if(delete(targetKey)==false)
            returnValue = false;
        //inserting failed
        else if(insert(newListing) == false) {
            returnValue = false;
        }
        else {
            returnValue = true;           
        }
        return returnValue;
    }
    //insert
    public boolean insert(StudentListings newListing) {
        int i = binarySearch(data, targetKey);
        boolean returnValue;
 
        for(int j=next; j>=i;j--) {
            data[j] = data[j-1];
        }
        //array is full
        if(next >= size) {
            returnValue = false;
        }
        //not enough system memory
        else if(data[next] == null) {
            returnValue = false;
        }
        else {
            returnValue = true;
        }
        next++;
        data[i]=newListing.deepCopy();
        
        return returnValue;
    }
}
