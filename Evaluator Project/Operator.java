/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluator;

/**
 *
 * @author Admin
 */
class Operator<T> implements OperatorStack<T> {
    
    private T[] arrary;
    private int total;
    
    //Default Contructor
    public Operator(){}
    
    //Method for input and prints out parameters
    public Operator(String str){
        System.out.println(str);
    }
    
    //Overloaded method for return String value
    public String Operator(String str2){
        return str2;
    }

    @Override
    public OperatorStack<T> push(T op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
