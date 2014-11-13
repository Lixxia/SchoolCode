package p11;

/**
 * @author Laura Barber
 * Collaborated with Katie Vaughan
 * October 29th 2012 Programming Exercises 8.39 in 'Data
 * Structures and Algorithms Using Java' textbook.
 * 
 * Referenced: http://www.javapractices.com/topic/TopicAction.do?Id=62
 * for way to generate a random integer.
 */
public class Driver {

    public static void main(String[] args) {
        int[] array1k = MergeSort.createArray(1000);
        int[] array5k = MergeSort.createArray(5000);
        int[] array10k = MergeSort.createArray(10000);
        int[] array100k = MergeSort.createArray(100000);
        System.out.println("-----------------------------------");
        MergeSort.sort(array1k);
        System.out.println("-----------------------------------");
        MergeSort.sort(array5k);
        System.out.println("-----------------------------------");
        MergeSort.sort(array10k);
        System.out.println("-----------------------------------");
        MergeSort.sort(array100k);
        System.out.println("-----------------------------------");
    }

}
