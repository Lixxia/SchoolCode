package P4;

import javax.swing.JOptionPane;

/**
 *
 * @author Laura Barber Collaborated with Katie Vaughan.
 *
 * September 9th 2012 Programming Exercises 3.21 & 3.24 in Data Structures and
 * Algorithms Using Java textbook.
 *
 * Resources used: Data Structures and Algorithms Using Java by William
 * McAllister
 *
 */
public class Driver {

    public static void main(String[] args) {
        //initialize infixExpression
        String infixExpression = "";
        //Runs until user inputs -1
        while (!(infixExpression.equals("-1"))) {
            infixExpression = JOptionPane.showInputDialog("Input an infix expression: ");
            String postfixExpression = ArithmeticExpressionConversions.convertInfixToPostfix(infixExpression);
            System.out.println("Postfix Expression: "
                    + ArithmeticExpressionConversions.convertInfixToPostfix(infixExpression));
            System.out.println("Result: "
                    + ArithmeticExpressionConversions.evaluatePostfixExpression(postfixExpression));
        }
        //Prints when user enters -1
        System.out.println("Program ended.");

    }
}
