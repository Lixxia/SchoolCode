package P6;

/**
 *
 * @author Laura Barber
 *
 * October 8th 2012 Programming Exercises 5.40 in Data Structures and Algorithms
 * Using Java textbook.
 *
 * Resources used: Data Structures and Algorithms Using Java by William
 * McAllister
 */
public class Driver {

    /**
     * Note: When calling the methods update, fetch and delete the key is the
     * ticketNum, NOT the name.
     */
    public static void main(String[] args) {
        /**
         * Pre-Conditions: new Listings must be in the format (ticketNum, name)
         * Post-Conditions: tests each method (insert, update, fetch, delete)
         */
        PerfectHashed dataBase = new PerfectHashed();
        Listing bill = new Listing("2999", "Bill");
        Listing tom = new Listing("3354", "Tom");
        Listing newBill = new Listing("3000", "William");

        //test insert
        System.out.println("Testing Insert:");
        dataBase.insert(bill);
        dataBase.insert(tom);
        System.out.println(bill);
        System.out.println(tom);

        //test update
        System.out.println("\nTesting Update:");
        System.out.println(dataBase.update("2999", newBill));

        //fetch
        System.out.println("\nTesting Fetch:");
        bill = dataBase.fetch("3000");
        System.out.println(bill);

        //delete
        System.out.println("\nTesting Delete:");
        System.out.println(dataBase.delete("3000"));
        bill = dataBase.fetch("3000");
        System.out.println("\nTesting Fetch after deletion:");
        System.out.println(bill);


    }
}
