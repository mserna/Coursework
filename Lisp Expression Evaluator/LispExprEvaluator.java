package PJ2;
import java.util.*;

public class LispExprEvaluator
{
    // Current input Lisp expression
    private String inputExpr;

    // Main expression stack & current operation stack, see algorithm in evaluate()
    private Stack<Object> thisExprStack;
    private Stack<Double> thisOpStack;

    // default constructor
    // set inputExpr to "" 
    // create stack objects
    public LispExprEvaluator()
    {
        inputExpr = "";
        thisExprStack = new Stack<Object>();
        thisOpStack = new Stack<Double>();
    }

    // constructor with an input expression 
    // set inputExpr to inputExpression 
    // create stack objects
    public LispExprEvaluator(String inputExpression) 
    {
        if(inputExpression == null){
            throw new LispExprEvaluatorException();
        }
        
        inputExpr = inputExpression;
        thisExprStack = new Stack<Object>();
        thisOpStack = new Stack<Double>();
    }

    // set inputExpr to inputExpression 
    // clear stack objects
    public void reset(String inputExpression) 
    {
        if(inputExpression == null){
            
            throw new LispExprEvaluatorException();
        }
        inputExpr = inputExpression;
        thisExprStack.clear();
        thisOpStack.clear();
        
    }


    // This function evaluates current operator with its operands
    // See complete algorithm in evaluate()
    //
    // Main Steps:
    //      Pop operands from thisExprStack and push them onto 
    //          thisOpStack until you find an operator
    //      Apply the operator to the operands on thisOpStack
    //          Push the result into thisExprStack
    //
    private void evaluateCurrentOperation()
    {
         String currOp;
         boolean numeric = true;
         do{
             currOp = (String.valueOf(thisExprStack.pop()));

             try{
                 Double number = Double.parseDouble(currOp);
                 thisOpStack.push(number);

             }catch(NumberFormatException nfe){
                 numeric = false;
             }
         } while(numeric);


         double result;
         switch (currOp) {
             case "*":
                 result = thisOpStack.pop();
                 while(!thisOpStack.isEmpty()){
                     result *= thisOpStack.pop();
                 }
                 break;
             case "/":
                 result = thisOpStack.pop();
                 while(!thisOpStack.isEmpty()){
                     result /= thisOpStack.pop();
                 }
                 break;
             case "+":
                 result = thisOpStack.pop();
                 while(!thisOpStack.isEmpty()){
                     result += thisOpStack.pop();
                 }
                 break;
             case "-":
                 result = thisOpStack.pop();
                 while(!thisOpStack.isEmpty()){
                     result -= thisOpStack.pop();
                 }
                 break;

             default:
                 result = thisOpStack.pop();
                 break;
         }

         thisExprStack.push(result);
    }

    /**
     * This funtion evaluates current Lisp expression in inputExpr
     * It return result of the expression 
     *
     * The algorithm:  
     *
     * Step 1   Scan the tokens in the string.
     * Step 2       If you see an operand, push operand object onto the thisExprStack
     * Step 3           If you see "(", next token should be an operator
     * Step 4       If you see an operator, push operator object onto the thisExprStack
     * Step 5       If you see ")"  // steps in evaluateCurrentOperation() :
     * Step 6           Pop operands and push them onto thisOpStack 
     *                  until you find an operator
     * Step 7           Apply the operator to the operands on thisOpStack
     * Step 8           Push the result into thisExprStack
     * Step 9    If you run out of tokens, the value on the top of thisExprStack is
     *           is the result of the expression.
     */
    public double evaluate()
    {

        // use scanner to tokenize inputExpr
        Scanner inputExprScanner = new Scanner(inputExpr);
        
        // Use zero or more white space as delimiter,
        // which breaks the string into single character tokens
        inputExprScanner = inputExprScanner.useDelimiter("\\s*");

        // Step 1: Scan the tokens in the string.
        while (inputExprScanner.hasNext())
        {

            // Step 2: If you see an operand, push operand object onto the exprStack
            if (inputExprScanner.hasNextInt())
            {
                // This force scanner to grab all of the digits
                // Otherwise, it will just get one char
                String dataString = inputExprScanner.findInLine("\\d+");

        // more ...
                thisExprStack.push(Double.parseDouble(dataString));
            }
            else
            {
                // Get next token, only one char in string token
                String aToken = inputExprScanner.next();
                char item = aToken.charAt(0);

                switch (item)
                {
                case '(':
                    break;

                case ')':
                    evaluateCurrentOperation();
                    break; 

                case'*':
                    thisExprStack.push("*");
                    break;

                case'+':
                    thisExprStack.push("+");
                    break; 

                case'/':
                    thisExprStack.push("/");
                    break;

                case'-':
                    thisExprStack.push("-");
                    break;  

                // Step 3: If you see "(", next token shoube an operator
                // Step 4: If you see an operator, push operator object onto the exprStack
                // Step 5: If you see ")"  do steps 6,7,8 in evaluateCurrentOperation() :
                    default:  // error
                        throw new LispExprEvaluatorException(item + " is not a legal expression operator");
                } // end switch
            } // end else
        } // end while
    return Double.parseDouble(String.valueOf(thisExprStack.pop()));
    }
    

    //=====================================================================
    // DO NOT MODIFY ANY STATEMENTS BELOW
    //=====================================================================

    // This static method is used by main() only
    private static void evaluateExprTest(String s, LispExprEvaluator expr)
    {
        Double result;
        System.out.println("Expression " + s);
    expr.reset(s);
        result = expr.evaluate();
        System.out.printf("Result %.2f\n", result);
        System.out.println("-----------------------------");
    }

    // define few test cases, exception may happen
    public static void main (String args[])
    {
        LispExprEvaluator expr= new LispExprEvaluator();
        String test1 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)))";
        String test2 = "(+ (- 632) (* 21 3 4) (/ (+ 32) (* 1) (- 21 3 1)))";
        String test3 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 1) (- 2 1 )))";
        String test4 = "(+ (/2))";
        String test5 = "(+ (/2 3 0))";
        String test6 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 3) (- 2 1 ))))";
    evaluateExprTest(test1, expr);
    evaluateExprTest(test2, expr);
    evaluateExprTest(test3, expr);
    evaluateExprTest(test4, expr);
    evaluateExprTest(test5, expr);
    evaluateExprTest(test6, expr);
    }
}
