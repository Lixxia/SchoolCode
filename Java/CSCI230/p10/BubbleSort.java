package p10;

/**
 * @author Laura Barber
 */
public class BubbleSort {
    
    /**
     * Pre-Conditions: Accepts an integer array of any size, consisting of any
     * valid integers.
     * Post-Conditions: Prints the sorted array.
     * @param numbers
     */
    public static void sort(int[] numbers) {
        //sets swapped to true for starting
        boolean swapped = true;
        //tracks num of swaps
        int track = 0;
        //variable to hold int for swapping
        int temp;
        //initialize string to hold final sorted array
        String sorted = "";
        while(swapped) {
            swapped = false;
            track++;
            for(int i=0; i < numbers.length - track; i++) {
                if(numbers[i] > numbers[i + 1]) {
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    swapped = true;
                }  
            }
        }
        //prints out the sorted array
        for(int i=0; i < numbers.length; i++) {
                sorted = sorted + " " + numbers[i];
            }
            System.out.println(sorted);
    }

    /**
     * Pre-Conditions: Accepts an integer array of any size, consisting of any
     * valid integers.
     * Post-Conditions: Prints out the sorted array, the number of swaps preformed 
     * and the number of comparisons that happen within the algorithm.
     * @param numbers
     */
    public static void sortWithReport(int[] numbers) {
        //Set swapped to true for starting
        boolean swapped = true;
        //initialize tracker for number of swaps
        int track = 0;
        //initialize tracker for number of comparisons
        int comp = 0;
        //variable to hold int for swapping
        int temp;
        //initialize string to hold final sorted array
        String sorted = "";
 
        while(swapped) {
            swapped = false;
            track++;
            for(int i=0; i < numbers.length - track; i++) {
                comp++;
                if(numbers[i] > numbers[i + 1]) {
                    //swaps two numbers
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    swapped = true;
                }    
            }  
        }
        //Converts final sorted array to string for printing
        for(int i=0; i < numbers.length; i++) {
                sorted = sorted + " " + numbers[i];
            }
        System.out.println("Sorted Array:" + sorted);
        System.out.println("Number of swaps: " + track);
        System.out.println("Number of comparison: " + comp);          
    }  
}
