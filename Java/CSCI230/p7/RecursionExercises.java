package p7;
/**
 *
 * @author Laura Barber
 * 10/15/12
 */
public class RecursionExercises {
    
    /**
     * Exercise 14. A recursive solution for the sum of integers from a to b,
     * a > b.
     * @param a
     * @param b
     * Pre-Conditions: a must be larger than b.
     * Post-Conditions: the sum of integers from a to be will be returned
     */
    public int exercise14(int a, int b) {
        //base case is 0, otherwise add ints
        return (a<b)?0: a + exercise14(a-1,b);
    }
    /**
     * Exercise 15. A recursive solution for outputting array of characters, c, 
     * given starting and ending indices.
     * @param start 
     * @param end
     * Pre-Conditions: Start index must be > 0 and end index must be within the
     * bounds of the character array.
     * Post-Conditions: will return null if start==end, will otherwise return a
     * character array of the characters within the initially specified indices.
     */
    //Initializing charArray string outside method.
    private String cStr = "";
    public char[] exercise15(int start, int end) {
        char[] returnVal;
        //Creating the character array to be used for testing
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        //Base case        
        if(start==end) {
            returnVal = null;
        }
        //check if user enters an end index too large for the array
        else if(end > c.length) {
            String error = "End index is out of bounds.";
            returnVal = error.toCharArray();
        }
        //check if user enters a start index below 0
        else if(start < 0) {
            String error = "Start index is out of bounds.";
            returnVal = error.toCharArray();
        }
        else{
            cStr = cStr + c[start];
            exercise15(start + 1, end);
            returnVal = cStr.toCharArray();
        }
        return returnVal;
    }
    
    /**
     * Exercise 16.A recursive solution for binary search of an array to locate
     * the value aKey.
     * @param sortedArray
     * @param aKey
     * Pre-Conditions: When called this method will initialize the start and end
     * variables, calling a private binary search method.
     * Post-Conditions: Will return aKey if found, otherwise returns -1. 
     * 
     */
    public int exercise16(int[] sortedArray, int aKey) {
        return exercise16(sortedArray, aKey, 0, sortedArray.length - 1);
    }
    /**
     * Private Binary Search Method. 
     * @param sortedArray
     * @param aKey
     * @param start
     * @param end
     * Pre-Conditions: This method is only called through use of the public 
     * exercise16 method that accepts only sortedArray and aKey.
     * Post-Conditions: Will return aKey if found, otherwise returns -1.
     */
    //Hooray for overloading!
    private int exercise16(int[] sortedArray, int aKey, int start, int end) {
        int returnVal;
        int mid = (start + end) / 2;
        //Base case
        if(start > end) {
            returnVal = -1;
        }
        //if key is less than the mid value of array, cut off the right side
        else if(aKey < sortedArray[mid]) {
            returnVal = exercise16(sortedArray, aKey, start, mid - 1);
        }
        //if key is greater than mid value of array, cut off left side
        else if(aKey > sortedArray[mid]) {
            returnVal = exercise16(sortedArray, aKey, mid + 1, end);
        }
        else {
            returnVal = mid;
        }
        return returnVal;
    }
    
    /**
     * Exercise 17. A recursive solution for the product of two integers a and b.
     * @param a
     * @param b
     * Pre-Conditions: Any real number may be entered
     * Post-Conditions: Will return product of two integers a and b.
     */
    public int exercise17(int a, int b) {
        int returnVal;
        //3 Base cases.
        if(a==0 || b == 0) {
            returnVal = 0;
        }
        else if(a==1) {
            returnVal = b;
        }
        else if(b==1) {
            returnVal = a;
        }
        else {
            returnVal = a + exercise17(a,b-1);
        }
        return returnVal;
    }    
}
