package P1;

public class SearchList {
    
    private int[] searchList;
    //Range set here for ease of use.
    private int range = 65000;
    
    //Builds Array SearchList
    public SearchList()
    {
        searchList = new int[range];
        for(int i = 0; i < range; i++)
        {
        searchList[i] = i + 1;      
        } 
    }
    //Returns list item at index i
    public int getList(int i)
    {
        return searchList[i];
    }
    //Returns length of list
    public int getLength()
    {
        return searchList.length;
    }
    //Used to test.
    /*
    public void printArray()
    {
        for(int i = 0; i < range; i++)
        {
            System.out.println(searchList[i]);
        }
    }
    */
    
}
