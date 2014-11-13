package p8;

/**
 *
 * @author Laura Barber
 * 10/22/12
 * 
 */
public class RecursionExercisesII {
    //Starting positions
    static int firstRow = 0;
    static int firstCol = 0;
    //size of board
    static int nRows = 10;
    static int nCols = 10;
    
    //Row and column increment values
    static int rowInc = 1;
    static int[] colInc = new int[3];
    
    //weight values of the board
    static int[][] board = {
	{0, 3, 5, 6, 1, 2, 7, 1, 9, 4},
	{8, 8, 3, 6, 5, 8, 3, 9, 1, 5},
	{6, 4, 3, 8, 7, 1, 2, 4, 7, 4},
	{5, 3, 8, 4, 2, 6, 7, 9, 3, 5},
	{1, 6, 3, 2, 1, 4, 3, 3, 7, 9},
	{7, 3, 7, 4, 4, 1, 5, 9, 9, 4},
	{1, 8, 6, 6, 8, 4, 8, 3, 8, 2},
	{4, 8, 1, 9, 7, 9, 2, 3, 5, 4},
	{9, 1, 4, 7, 3, 6, 8, 6, 1, 4},
	{6, 4, 7, 4, 8, 3, 6, 7, 2, 4}
    };
    
    //current best path
    static String path = "";
    //weight being compared to favWeight
    static int checkWeight;
    //current lowest weight
    static int favWeight;
    
    //main method
    public void produceRoute() {
        boolean success;
        colInc[0] = -1;
        colInc[1] = 0;
        colInc[2] = 1;
        
        success = nextMove(1, firstRow, firstCol);
        if(success==true) {
            for(int i=0; i < nRows; i++) {
                System.out.println();
                for(int j=0; j < nCols; j++) {
                    System.out.println(board[i][j] + "\t");
                }
            }
        }
        else {
            //~
        }
        //Final switch of the weight values
        checkWeight = checkWeight * -1;
        favWeight = favWeight *-1;
        if(checkWeight < favWeight) {
            favWeight = checkWeight;
        }
        else {
            //~
        }
        System.out.println("Minimal Weight = " + favWeight);
        /*
         * Could not for the life of me figure out how to get the correct path to
         * show instead of the whole shebang.
         */
        System.out.println(path);
    }
    
    /**
     * @param lastMoveNumber
     * @param fromRow
     * @param fromCol
     * Pre-Conditions: lastMoveNumber, fromRow and fromCal must be integers > 0.
     * Post-Conditions: returns true or false based upon if the nextMove has been
     * completed.
     */
    public static boolean nextMove(int lastMoveNumber, int fromRow, int fromCol) {
        int thisMoveNumber = lastMoveNumber + 1;
        int numOfChoices = 3;
        int choiceNum = 0;
        boolean atGoal = false;
        
        while(atGoal == false && choiceNum < numOfChoices) {
            int row = nextChoiceRow(fromRow);
            int column = nextChoiceColumn(choiceNum, fromCol);
            int weight;
            //System.out.println("Row: " + row + ", Column: " + column);
            if(validChoice(row, column)) {
                path = path + " (" + row + "," + column + ")";
                weight = board[row][column];
                //Make the value on the board negative to indicate that we've
                //already been there.
                board[row][column] = board[row][column] * -1;  
                
                recordChoice(row, column, weight);
                if(goalCheck(thisMoveNumber)) {
                    atGoal = true;
                }
                //make next move
                else {
                    atGoal = nextMove(thisMoveNumber, row, column);
                    //backtrack
                    if(atGoal == false) {
                        unrecordChoice(row, column, weight);
                    }
                }
            }
            choiceNum++; 
        }
        return atGoal;
        
    }
    
    
    /**
     * @param fromRow
     * Pre-Conditions: fromRow must be an integer > 0.
     * Post-Conditions: returns the nextRow
     *      will always increment 1.
     */
    public static int nextChoiceRow(int fromRow) {
        int nextRow = fromRow + rowInc;
        return nextRow;
    }
    
    
    /**
     * @param choiceNumber
     * @param fromCol
     * Pre-Conditions: choiceNumber and fromCol must be integers > 0.
     * Post-Conditions: returns the nextCol
     *      will either decrement by 1, stay the same or increment by 1.
     */
    public static int nextChoiceColumn(int choiceNumber, int fromCol) {
        int nextColumn = fromCol + colInc[choiceNumber];
        return nextColumn;
    }
    
    
    /**
     * @param row
     * @param column
     * Pre-Conditions: row and column must be integers >= 0 and within the bounds
     * of the board.
     * Post-Conditions: will return a boolean if the integers row and column are 
     * valid.
     */
    public static boolean validChoice(int row, int column) {
        boolean returnVal;
        if(row >= 0 && row < nRows &&
           column >= 0 && column < nCols &&
           board[row][column] > 0) {
            returnVal = true;
        }
        else {
            returnVal = false;
        }  
        return returnVal;
        
        
        
    }
    
    
    /**
     * @param row
     * @param column
     * Pre-Conditions: row, column and weight must be integers > 0.
     * Post-Conditions: records a choice and checks if the weight being currently
     * checked is less than the overall lowest/favorite weight if so then switches
     * the checked weight to favorite weight.
     */
    public static void recordChoice(int row, int column, int weight) {
       path = path + " (" + row + "," + column + ")";
       if(favWeight == 0) {
           favWeight = checkWeight;
       }
       else if(checkWeight < favWeight) {
           favWeight = checkWeight;
           checkWeight = 0;
       }
       else {
           checkWeight = 0;
           checkWeight = checkWeight + weight;
       }
    }
    
    
    /**
     * @param row
     * @param column
     * @param weight
     * Pre-Conditions: row column and weight must be ints > 0.
     * Post-Conditions: removes the weight from the overall weight total.
     * Also removes the negative from a weight that was used to indicate a spot
     * that had already been traveled to.
     */
    public static void unrecordChoice(int row, int column, int weight) {
        board[row][column] = board[row][column] * -1; 
        checkWeight = checkWeight - weight;
    }
    
    /**
     *
     * @param thisMoveNumber
     * Pre-Conditions: thisMoveNumber must be > 0
     * Post-Conditions: returns a boolean if the goal of 100 moves has been 
     * reached.
     */
    public static boolean goalCheck(int thisMoveNumber) {
        boolean finished;
        if(thisMoveNumber == nRows * nCols) {
            finished = true;
        }
        else {
            finished = false;
        }
        return finished;
    }

}
