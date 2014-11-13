package p11;
import java.util.Random;

/**
 *
 * @author Laura Barber
 */
public class MergeSort {
    //Initialize number of swaps and compares
    static int swaps = 0;
    static int compares = 0;
    /**
     * Increments swap count by one
     * @return swaps
     */
    public static int swapCount() {
        swaps++;
        return swaps;
    } 
    /**
     * Increments compare count by one
     * @return compares
     */
    public static int compareCount() {
        compares++;
        return compares;
    }   
    /**
     * Pre-Conditions: Accepts integer defining the size of the array, must be a 
     * positive non-zero number.
     * Post-Conditions: Creates an array of given size and fill each spot with a 
     * randomly generated number within the range 0-1000000.
     * @param size
     */
    public static int[] createArray(int size) {
        int[] numbers = new int[size];
        Random randomGenerator = new Random();
        for(int i = 0; i < size; i++) {
            int randomInt = randomGenerator.nextInt(1000000);
            numbers[i] = randomInt;
        } 
        return numbers;
    }
    /**
     * Pre-Conditions: Accepts an array of integers
     * Post-Conditions: Initializes values needed to call mergeSort method,
     * calculates estimatedSwaps/Comparisons and prints out a report of the 
     * swaps/comparisons versus the estimated swaps/comparisons
     * @param numbers
     */
    public static void sort(int[] numbers) {        
        int[] temp = new int[numbers.length];
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        
        int n = numbers.length;
        double estimatedSwaps = 2.67*((0.75*n)*(Math.log(n)/Math.log(2)));
        double estimatedComparisons = (0.75*n)*(Math.log(n)/Math.log(2));
        
        mergeSort(numbers, temp, leftIndex, rightIndex);
                
        String report = ("Number of Integers: " + numbers.length
                + "\nSwaps: " + swaps
                + "\nComparisons: " + compares
                + "\nEstimated Swaps: " + Math.round(estimatedSwaps)
                + "\nEstimated Comparisons: " + Math.round(estimatedComparisons));
        
        System.out.println(report);
        
    }
    /**
     * Pre-Conditions: accepts the array numbers which is a populated array of 
     * integers, the array temp which is an empty array with the same size as the
     * numbers array, the integer leftIndex which is a positive number, the 
     * integer rightIndex which is a non-zero positive number.
     * Post-Conditions: Recursively calls itself until the original array has been
     * split down to two items to be compared, then calls merge to merge all the 
     * smaller sorted arrays back together.
     * @param numbers
     * @param temp
     * @param leftIndex
     * @param rightIndex
     */
    public static void mergeSort(int[] numbers, int temp[], int leftIndex, 
            int rightIndex) {
        int midIndex = (rightIndex + leftIndex) / 2;
        int nItems = rightIndex - leftIndex + 1;
        if(nItems == 1) {
            return;
        }    
        //sort the left sublist
        mergeSort(numbers, temp, leftIndex, midIndex);
        //sort the right sublist
        mergeSort(numbers, temp, midIndex + 1, rightIndex);
        //merge two sorted sublists & return information
        merge(numbers, temp, leftIndex, midIndex + 1, rightIndex);
    }
    
    /**
     * Pre-Conditions: accepts the array numbers which is a populated array of 
     * integers, the array temp which is an empty array with the same size as the
     * numbers array, the integer leftIndex which is a positive number, the 
     * integer rightIndex which is a non-zero positive number.
     * Post-Conditions: Checks values of reduced size arrays and puts them into 
     * the temp array so that they may be re-sorted into the number array.
     * @param numbers
     * @param temp
     * @param leftIndex
     * @param midIndex
     * @param rightIndex
     */
    public static void merge(int numbers[], int temp[], int leftIndex, 
            int midIndex, int rightIndex) {              
                
        int leftEnd = midIndex - 1;
        int tempsIndex = leftIndex;
        int nItems = rightIndex - leftIndex + 1;
        while((leftIndex <= leftEnd) && (midIndex <= rightIndex)) {
            //compares++;
            compareCount();
            //move items into temp
            if(numbers[leftIndex] <= numbers[midIndex]) {
                //from left sublist
                temp[tempsIndex] = numbers[leftIndex];
                tempsIndex++;
                leftIndex++;
            }
            else {
                //move item from right sublist into temp
                //swaps++;
                swapCount();
                temp[tempsIndex] = numbers[midIndex];
                tempsIndex++;
                midIndex++;
            }
        }
        if(leftIndex <= leftEnd) {
            //left sublist is not empty
            while(leftIndex <= leftEnd) {
                //swaps++;
                swapCount();
                //copy remaining left sublist into temp
                temp[tempsIndex] = numbers[leftIndex];
                leftIndex++;
                tempsIndex++;
            }
        }
        else {
            //right sublist is not empty
            while(midIndex <= rightIndex) {
                //swaps++;
                swapCount();
                //copy remaining right sublist into temp
                temp[tempsIndex] = numbers[midIndex];
                midIndex++;
                tempsIndex++;
            }
        }
        for(int i=0; i < nItems; i++) {
            //swaps++;
            swapCount();
            //copy int[] temp into int[] numbers
            numbers[rightIndex] = temp[rightIndex];
            rightIndex--;
        }
    }
}
