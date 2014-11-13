/**
 * @author Laura Barber
 * @collaborator Katherine Vaughan
 * @References:
 *      Data Structures and Algorithms Using Java(Book)
 *      www.roseindia.net/java/java-get-example/java-get-user-input.shtml
 * THIS WAS HARD.
 * 
 */

package P1;

public class Driver{
    public static void main(String[] args) {
        //Gets Input
        InputN input = new InputN();
        int n = input.getInput();
        //Initialize nums
        int total = 0;
        int avg = 0;
        //Runs binary algorithm n times
        for(int x=0; x < n; x++) {
            BinarySearch binary = new BinarySearch();
            total = total + binary.Algorithm(); 
            avg = total / n;
        } 
        //Prints the answers!
        System.out.println("Average number of times executed: " + avg); 
        System.out.println("log_2(65000) ~= 15.9");
    }
}
