package P4;

/**
 *
 * @author Laura Barber
 */
public class ArithmeticExpressionConversions {

    /**
     * Pre-Conditions. Something must be entered, do not input a blank field or
     * expression. Example: ( ) and ( ( ) ) are not valid expressions.
     *
     * Numbers entered must be integers. There must be a single space delimiting
     * every element in the infix expressions. Expressions must be fully
     * parenthesized; every operator has two operands and will be surrounded
     * with one set of parentheses. The entire expression must be surrounded by
     * one set of parentheses. Use only the operators *, + , - , /. Examples: (
     * ( 3 + 2 ) - ( 4 * 5 ) ) is a valid expression. ( 3 + 2 ) - ( 4 * 5 ) is
     * not a valid expression.
     *
     * Enter -1 to terminate program.
     *
     * Post-Conditions. All elements are delimited by spaces.
     *
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
        //New stack for operators
        StackI operatorStack = new StackAsSLL();
        operatorStack.showAll();
        //Trackers
        int openParenthesis = 0;
        int closedParenthesis = 0;
        int intCount = 0;

        //Iterate through for length of array of all expressions
        for (int i = 0; i < expElements.length; i++) {
            //If operator than push to stack
            if (expElements[i].equals("*") || expElements[i].equals("/")
                    || expElements[i].equals("+") || expElements[i].equals("-")) {
                operatorStack.push(new Listing(expElements[i]));
            } //if open parenthesis add to count
            else if (expElements[i].equals("(")) {
                openParenthesis++;
            } //if closed parenthesis add to count and pop operator
            else if (expElements[i].equals(")")) {
                closedParenthesis++;
                postfix += " " + operatorStack.pop();
            } //otherwise it is an integer, add it to array of operands
            else {
                operands[i] = expElements[i];
                postfix += " " + operands[i];
                intCount++;
            }

        }
        //Error detection for not enough matching parentheses.
        if (openParenthesis != closedParenthesis) {
            postfix = "Parenthesis not equal error.";
        }
        //return final expression in postfix notation, delimited by spaces or errors
        return postfix;
    }

    public static int evaluatePostfixExpression(String postfixExpression) {
        int returnVal;
        //Error detection
        if (postfixExpression.equals("Parenthesis not equal error.")) {
            returnVal = -1;
        } else {
            //Post Fix Expression split on " "
            String[] expElements = postfixExpression.split(" ");
            //String array of numbers only.
            String[] numElements = new String[postfixExpression.length()];

            //For doing math.
            int operatedVal;

            //New Expressions for operands
            String operands = new String();
            //New stack of operands
            StackI operandStack = new StackAsSLL();

            //iterates through for number of total elements
            for (int i = 0; i < expElements.length; i++) {
                String stringConvert1 = "";
                String stringConvert2 = "";

                //if expression in array is not an operand, that is to say it is a
                //number add it to array of numbers then push to stack of numbers
                //(still in string form)
                if (!(expElements[i].equals("") || expElements[i].equals(" ")
                        || expElements[i].equals("+") || expElements[i].equals("-")
                        || expElements[i].equals("*") || expElements[i].equals("/")
                        || expElements[i].equals(")") || expElements[i].equals("("))) {
                    numElements[i] = expElements[i];
                    operandStack.push(new Listing(numElements[i]));
                }

                //If + then perform appropriate mathematical operations
                if (expElements[i].equals("+")) {
                    stringConvert1 += operandStack.pop();
                    stringConvert2 += operandStack.pop();
                    int val1 = Integer.valueOf(stringConvert1);
                    int val0 = Integer.valueOf(stringConvert2);
                    operatedVal = val1 + val0;
                    operandStack.push(new Listing(Integer.toString(operatedVal)));
                } //If - then perform appropriate mathematical operations
                else if (expElements[i].equals("-")) {
                    stringConvert1 += operandStack.pop();
                    stringConvert2 += operandStack.pop();
                    int val1 = Integer.valueOf(stringConvert1);
                    int val0 = Integer.valueOf(stringConvert2);
                    operatedVal = val0 - val1;
                    operandStack.push(new Listing(Integer.toString(operatedVal)));
                } //If * then perform appropriate mathematical operations
                else if (expElements[i].equals("*")) {
                    stringConvert1 += operandStack.pop();
                    stringConvert2 += operandStack.pop();
                    int val1 = Integer.valueOf(stringConvert1);
                    int val0 = Integer.valueOf(stringConvert2);
                    operatedVal = val1 * val0;
                    operandStack.push(new Listing(Integer.toString(operatedVal)));

                } //If / then perform appropriate mathematical operations
                else if (expElements[i].equals("/")) {
                    stringConvert1 += operandStack.pop();
                    stringConvert2 += operandStack.pop();
                    int val1 = Integer.valueOf(stringConvert1);
                    int val0 = Integer.valueOf(stringConvert2);
                    operatedVal = val0 / val1;
                    operandStack.push(new Listing(Integer.toString(operatedVal)));
                }
            }
            //Initializing calculatedValue (another workaround for expression > int)
            String calculatedValue = "";
            //pop from the stack of operands resulting in the final calculated value
            calculatedValue += operandStack.pop();
            //return integer value of the string calculatedValue.
            returnVal = Integer.valueOf(calculatedValue);
        }
        return returnVal;
    }
}
