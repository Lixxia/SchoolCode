package p12;

/**
 * @author Laura Barber
 * Collaborated with Katie Vaughan
 * November 19th 2012 Programming Exercises 9.35 in 'Data
 * Structures and Algorithms Using Java' textbook.
 */
public class Driver {
    public static void main(String[] args) {
        int size = 10;
        SimpleGraph testGraph = new SimpleGraph(size);
        System.out.println("Testing creation of a graph of the specified size. "
                + "(" + size + " vertices)");
        for(int i=0; i < size; i++) {
            testGraph.insertVertex(i, new Listing("vertex " + i));
            testGraph.showVertex(i);
        }
        System.out.println("Testing expansion of that graph. (Adding " + size 
                + " additional vertices)");
        for(int j=size; j < size*2; j++) {
            testGraph.insertVertex(j, new Listing("vertex " + j));
            testGraph.showVertex(j);
        }   
    }
}
