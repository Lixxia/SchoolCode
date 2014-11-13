package p10;
import javax.swing.JOptionPane;

/**
 * @author Laura Barber
 * Collaborated with Katie Vaughan
 * October 29th 2012 Programming Exercises 8.34 and 8.35 in 'Data
 * Structures and Algorithms Using Java' textbook.
 */
public class Driver {

    /**
     * Pre-Conditions: Accepts user input of 1 or 2
     * Post-Conditions: if user inputs 1 will print only the sorted array. if
     * user inputs 2 will print the sorted array with the number of swaps and
     * number of comparisons.
     * if user inputs anything else will end the program and print error.
     */
    public static void main(String[] args) {
        //int[] numbers = {8, 2, 6, 10, 3, 1, 9};
        int[] numbers = {5, 1, 12, -5, 16};
        String userInput = JOptionPane.showInputDialog(
                "Input 1 to print only the sorted array.\n"
                + "Input 2 to print the sorted array with additional information.");
        if(userInput.equals("1")) {
            BubbleSort.sort(numbers);
        }
        else if(userInput.equals("2")) {
            BubbleSort.sortWithReport(numbers);
        }
        else {
            System.out.println("Not a valid choice.");
        }  
    }
}
