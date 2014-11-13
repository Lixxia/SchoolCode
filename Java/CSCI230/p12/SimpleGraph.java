package p12;

/**
 * @author Laura Barber
 */
public class SimpleGraph {
    Listing vertex[];
    int edge[][];
    int max, numVertices;
    
    /**
     * CONSTRUCTOR
     * Pre-Conditions: Accepts a positive, non-zero integer for the size of the
     * array.
     * Post-Conditions: Initializes the arrays, max, and number of vertices.
     * @param n
     */
    public SimpleGraph(int n) {
        vertex = new Listing[n];
        edge = new int[n][n];
        max = n;
        numVertices = 0;
    }
    
    /**
     * Pre-Conditions: Accepts a positive integer to identify the vertex and a 
     * new Listing to be associated with that vertex
     * Post-Conditions: Inserts the vertex. If the vertexNumber is greater than
     * the maximum then it copies the vertex array and increases the size, 
     * allowing expansion beyond the original specified size.
     * @param vertexNumber
     * @param newListing
     * @return
     */
    public boolean insertVertex(int vertexNumber, Listing newListing) {
        if(vertexNumber >= max) {
            int newMax = max*2;
            Listing newVertex[] = new Listing[newMax];
            System.arraycopy(vertex, 0, newVertex, 0, max);
            newVertex[vertexNumber] = newListing.deepCopy();
            numVertices++;
            vertex = newVertex;
        }
        else {
            vertex[vertexNumber] = newListing.deepCopy();
            numVertices++;
        }
        return true;
    }
    
    /**
     * Pre-Conditions: Accepts two numbers that reference the two vertices the
     * edge will be connected to.
     * Post-Conditions: Creates an edge between two given vertices.
     * @param fromVertex
     * @param toVertex
     * @return
     */
    public boolean insertEdge(int fromVertex, int toVertex) {
        boolean success;
        if(vertex[fromVertex] == null || vertex[toVertex] == null) {
            //vertex does not exist
            success = false;
        }
        else {
            edge[fromVertex][toVertex] = 1;
            success = true;
        }
        return success;
    }
    
    /**
     * Prints out the information associated with the vertex.
     * @param vertexNumber
     */
    public void showVertex(int vertexNumber) {
        System.out.println(vertex[vertexNumber]);
    }
    
    /**
     * Prints out information regarding edges.
     * @param vertexNumber
     */
    public void showEdges(int vertexNumber) {
        for(int column = 0; column < numVertices; column++) {
            if(edge[vertexNumber][column] == 1) {
                System.out.println(vertexNumber + " , " + column);
            }
        }
    }
}
