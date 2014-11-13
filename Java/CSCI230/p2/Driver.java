package p2;

import javax.swing.JOptionPane;

/**
 *
 * @author Laura Barber
 * collaborated with Katie Vaughan
 * 
 * August 4th 2012
 * Programming Exercises 2.19 & 2.20 in
 * Data Structures and Algorithms Using Java 
 * textbook.
 * 
 * Resources used:
 * Data Structures and Algorithms Using Java
 * 
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Test based on user input
        String question = ("What would you like to test?:" +
                "\nInput" +
                "\ntoString" +
                "\ncompareTo" +
                "\nInsert" +
                "\nFetch" +
                "\nDelete" +
                "\nUpdate" +
                "\nSize Input");
        String test = JOptionPane.showInputDialog(question);
        
        //Test input field
        if (test.equalsIgnoreCase("input")) {
            StudentListings listing = new StudentListings();
            listing.input();
            System.out.println(listing.toString());
        }
        //Test toString
        else if (test.equalsIgnoreCase("tostring")) {
            StudentListings listing = new StudentListings("Bob","56","2.5");
            System.out.println(listing.toString());
        }
        //test compareTo
        //bob is not doing well in school.
        else if (test.equalsIgnoreCase("compareto")) {
            StudentListings listing = new StudentListings("Bob","56","2.5");
            listing.compareTo("Bob");
        }
        //test Insert
        else if (test.equalsIgnoreCase("insert")) {
            SortedArray array = new SortedArray();
            array.insert(null);
        }
        //test fetch
        else if (test.equalsIgnoreCase("fetch")) {
            SortedArray array = new SortedArray();
            array.fetch("Bob");
        }
        //test delete
        else if (test.equalsIgnoreCase("delete")) {
            SortedArray array = new SortedArray();
            //will give error because no fred :(
            //shows error checking
            array.delete("Fred");
        }
        //test update
        else if (test.equalsIgnoreCase("update")) {
            SortedArray array = new SortedArray();
            array.update("Bob", null);
        }
        //test size input
        else if (test.equalsIgnoreCase("size input")) {
            String x = "Enter size of array ";
            int size = Integer.parseInt(JOptionPane.showInputDialog(x));
            SortedArray array = new SortedArray(size);
        } 
    }
}
