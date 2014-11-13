/**
 *
 * @author Laura Barber Collaborated with Katie Vaughan.
 *
 * October 1st 2012 Programming Exercises 4.32in Data Structures and Algorithms
 * Using Java textbook.
 *
 * Resources used: Data Structures and Algorithms Using Java by William
 * McAllister
 *
 */
package p5;

/**
 *
 * @author Laura Barber
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Constructs the queue
        SLLQueue<String> q = new SLLQueue<String>();
        String s;
        //Defines 3 strings that we will insert
        String s1 = ("element1");
        String s2 = ("element2");
        String s3 = ("element3");

        //Queues each item, prints true if successful
        //CURRENTLY IN THE WRONG ORDER, NOT SURE HOW TO FIX: SEE SLLQueue.java
        System.out.println(q.enque(s1));
        System.out.println(q.enque(s2));
        System.out.println(q.enque(s3));
        //Prints all elements in the queue
        q.showAll();

        //Dequeues all elements and prints the element dequeued
        s = q.deque();
        System.out.println("1st Deque:" + s);
        s = q.deque();
        System.out.println("2nd Deque:" + s);
        s = q.deque();
        System.out.println("3rd Deque:" + s);

        System.out.println("Finished.");

    }
}
