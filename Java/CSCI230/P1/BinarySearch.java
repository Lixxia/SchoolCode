package P1;

public class BinarySearch {
    SearchList list = new SearchList();
   
    //Initialize Errythin'.
    private int comparisonCount = 1;
    private int length = list.getLength();
    private int low = 0;
    private int high = (length - 1);
    private int i = (high + low)/2;
    private int targetInt = 1 + (int)(Math.random()*length); 
    private int currentInt = list.getList(i);
    
    //Binary Search Alg. Returns num of times it runs.
    public int Algorithm() {
        while(targetInt != list.getList(i) && high != low) {
            comparisonCount++;
            if(targetInt < list.getList(i)) {
                high = i - 1;
            }
            else {
                low = i + 1;
                
            }
            i = (high+low)/2;
        }
        return comparisonCount;
    }
    //Used for testing
    /*
    public void printTest() {
        System.out.println("count:" + comparisonCount);
        System.out.println("length:" + length);
        System.out.println("high:" + high);
        System.out.println("low:" + low);
        System.out.println("i:" + i);
        System.out.println("current:" + currentInt);
        System.out.println("//");
    }
    */
    
    
}
