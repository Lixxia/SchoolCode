package p9;

/**
 * @author Laura Barber
 * Collaborated with Katie Vaughan
 * October 29th 2012 Programming Exercises 7.29 in 'Data
 * Structures and Algorithms Using Java' textbook.
 */
public class Driver {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        
        //Building the tree, also a test of insert
        binarySearchTree.insert(50);
        binarySearchTree.insert(40);
        binarySearchTree.insert(63);
        binarySearchTree.insert(35);
        binarySearchTree.insert(47);
        binarySearchTree.insert(53);
        binarySearchTree.insert(70);
        binarySearchTree.insert(43);
        binarySearchTree.insert(68);
        binarySearchTree.insert(80);
        
        System.out.println("Testing for something not contained in the tree: " +
                binarySearchTree.fetch(67));
        System.out.println("Testing for something contained in the tree: " +
                binarySearchTree.fetch(68));
       
        //Testing NLR Scan
        binarySearchTree.scanNLR(binarySearchTree);
    }
}
