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
class Operand<T> implements OperatorStack<T> {
    
    //Default contructor
    public Operand(){}
    
    //Method that prints out str parameter
    public Operand(String str){
        System.out.println(str);
    }
    
    //Overloaded method that returns String value
    public String Operand(String str2){
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
