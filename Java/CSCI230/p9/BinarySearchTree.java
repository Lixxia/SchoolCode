package p9;

/**
 * @author Laura Barber
 */
public class BinarySearchTree implements BinarySearchTreeI {
    private int size = 15;
    //Binary tree array
    int[] data = new int[size];
        
    /**
     * Pre-Conditions: accepts a binarySearchTree
     * Post-Conditions: prints the NLR traversal path
     * @param binarySearchTree
     */
    public void scanNLR(BinarySearchTree binarySearchTree) {       
        int i = 0;
        //string to hold left children
        String lc = "";
        //string to hold right children
        String rc = "";
        while(i < size) {
            if(data[i] < data[0]) {
                lc = lc + " , " + Integer.toString(data[i]);
            }
            else if(data[i] > data[0]) {
                rc = rc + " , " + Integer.toString(data[i]);
            }
            i++;    
        }
        System.out.println("NLR traversal: " + Integer.toString(data[0]) + lc + rc);
    }
    
    /**
     * Pre-Conditions: Accepts non-zero and non-negative integers to be inserted
     * into the binary search tree.
     * Post-Conditions: inserts the given integer into the binary search tree
     * @param newListing
     */
    @Override
    public boolean insert(int newListing) {
        int i = 0;
        boolean success;
        while(i < size && data[i]!=0) {
            if(data[i] > newListing) {
                //search left subtree
                i = 2 * i + 1;
            }
            else {
                //search right subtree
                i = 2 * i + 2;                
            }            
        }
        if(i >= size) {
            success = false;
        }
        else {
            //insert node
            data[i] = newListing;
            success = true;
        }
        return success;
    }
    
    /**
     * Pre-Conditions: Accepts non-zero and non-negative integers to be inserted
     * into the binary search tree.
     * Post-Conditions: Returns 0 if the integer is not found, returns the integer 
     * being searched for if it is located within the tree
     * @param targetKey
     */
    @Override
    public int fetch(int targetKey) {
        int i = 0;
        int returnVal;
        while(i < size && data[i]!=0 && data[i] != targetKey) {
            if(data[i] > targetKey) {
                //search left subtree
                i = 2 * i + 1;
            }
            else {
                //search right subtree
                i = 2 * i + 2;
            }
        }
        if(i >= size || data[i]==0) {
            returnVal = 0;
        }
        else {
            returnVal = data[i];
        }
        return returnVal;
    }
}
