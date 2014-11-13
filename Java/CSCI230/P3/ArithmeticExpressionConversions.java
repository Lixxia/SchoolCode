package P3;
import java.util.*;
/**
 *
 * @author Laura
 */
public class ArithmeticExpressionConversions {
    /**
     * Pre-Conditions. Numbers entered must be integers. There must be a single 
     * space delimiting every element in the infix expressions. Expressions must
     * be fully parenthesized; every operator has two operands and will be 
     * surrounded with parentheses. 
     * Post-Conditions. All elements are delimited by spaces. 
     * @param infixExpression
     * @return 
     */

    public static String convertInfixToPostfix(String infixExpression) {
        //Initializing final return string
        String postfix = "";
        //String Array of all elements
        String[] expElements = infixExpression.split(" ");
        //New String Array for the numbers
        String[] operands = new String[infixExpression.length()];
        //New expressions for operators
        Expressions operators = new Expressions();
        //New stack for operators
        Stack operatorStack = new Stack();
        
        //Trackers for parentheses
        int openParenthesis = 0;
        int closedParenthesis = 0;
        
        //Iterate through for length of array of all expressions
        for(int i = 0; i < expElements.length; i++) {
            //If operator than push to stack
            if(expElements[i].equals("*")||expElements[i].equals("/")
                    ||expElements[i].equals("+")||expElements[i].equals("-")) {
                operatorStack.push(new Expressions(expElements[i]));
            }
            //if open parenthesis add to count
            else if(expElements[i].equals("(")) {
                openParenthesis++;
            }
            //if closed parenthesis add to count and pop operator
            else if(expElements[i].equals(")")) {
                closedParenthesis++;
                postfix += " " + operatorStack.pop();
            }
            //otherwise it is an integer, add it to array of operands
            else {
                operands[i] = expElements[i];
                postfix += " " + operands[i];
            }
            
        }
        //Error detection for not enough matching parentheses.
        if(openParenthesis!=closedParenthesis){
            postfix = "Parenthesis not equal error.";
        }
        //return final expression in postfix notation, delimited by spaces
        return postfix;   
    }
    public static int evaluatePostfixExpression(String postfixExpression) {
        //Error detection
        if(postfixExpression.equals("Parenthesis not equal error.")){
            return -1;
        }
        //Post Fix Expression split on " "
        String[] expElements = postfixExpression.split(" ");
        //String array of numbers only.
        String[] numElements = new String[postfixExpression.length()];
        
        //For doing math.
        int operatedVal;        
        
        //New Expressions for operands
        Expressions operands = new Expressions();
        //New stack of operands
        Stack operandStack = new Stack();
        
        //iterates through for number of total elements
        for(int i=0; i < expElements.length; i++) {
            //Workaround because I was recieveing errors on converting
            //type Expressions to int.
            String stringConvert1 = "";
            String stringConvert2 = "";
            
            //if expression in array is not an operand, that is to say it is a
            //number add it to array of numbers then push to stack of numbers
            //(still in string form)
            if(!(expElements[i].equals("")||expElements[i].equals(" ")||
                    expElements[i].equals("+")||expElements[i].equals("-")||
                    expElements[i].equals("*")||expElements[i].equals("/"))) {
                numElements[i]=expElements[i];
                operandStack.push(new Expressions(numElements[i]));
            }
            
            //If + then perform appropriate mathematical operations
            if(expElements[i].equals("+")) {
                stringConvert1 += operandStack.pop();
                stringConvert2 += operandStack.pop();
                int val1 = Integer.valueOf(stringConvert1);
                int val0 = Integer.valueOf(stringConvert2);
                operatedVal = val1 + val0;
                operandStack.push(new Expressions(Integer.toString(operatedVal))); 
            }
            //If - then perform appropriate mathematical operations
            else if(expElements[i].equals("-")) {
                stringConvert1 += operandStack.pop();
                stringConvert2 += operandStack.pop();
                int val1 = Integer.valueOf(stringConvert1);
                int val0 = Integer.valueOf(stringConvert2);
                operatedVal = val0 - val1;
                operandStack.push(new Expressions(Integer.toString(operatedVal)));
            }
            //If * then perform appropriate mathematical operations
            else if(expElements[i].equals("*")) {
                stringConvert1 += operandStack.pop();
                stringConvert2 += operandStack.pop();
                int val1 = Integer.valueOf(stringConvert1);
                int val0 = Integer.valueOf(stringConvert2);
                operatedVal = val1 * val0;
                operandStack.push(new Expressions(Integer.toString(operatedVal)));
                
            }
            //If / then perform appropriate mathematical operations
            else if(expElements[i].equals("/")) {
                stringConvert1 += operandStack.pop();
                stringConvert2 += operandStack.pop();
                int val1 = Integer.valueOf(stringConvert1);
                int val0 = Integer.valueOf(stringConvert2);
                operatedVal = val1 / val0;
                operandStack.push(new Expressions(Integer.toString(operatedVal)));
            }
        }
        //Initializing calculatedValue (another workaround for expression > int)
        String calculatedValue = "";
        //pop from the stack of operands resulting in the final calculated value
        calculatedValue += operandStack.pop();
        //return integer value of the string calculatedValue.
        return Integer.valueOf(calculatedValue);
    }
    
    
}
