package p7;

/**
 *
 * @author Laura Barber
 *
 * October 15th 2012 Programming Exercises 6.(14, 15, 16, 17) in 'Data
 * Structures and Algorithms Using Java' textbook.
 *
 */
public class Driver {

    public static void main(String[] args) {
        RecursionExercises exercises = new RecursionExercises();
        //Testing 14, adding ints
        System.out.println("Exercise 14, Adding Integers:");
        System.out.println(exercises.exercise14(7, 2));

        //Testing 15, outputting array of characters
        System.out.println("\nExercise 15, Outputting Array of Characters:");
        System.out.println(exercises.exercise15(0, 5));

        //Testing 16, binary search
        System.out.println("\nExercise 16, Binary Search:");
        int[] array = new int[]{4, 5, 6, 7, 8, 9};
        System.out.println(exercises.exercise16(array, 7));

        //Testing 17, multiplying ints
        System.out.println("\nExercise 17, Multiplying Integers:");
        System.out.println(exercises.exercise17(6, 5));

    }
}
