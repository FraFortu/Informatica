/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

/**
 *
 * @author FortuF100
 */
public class Item {
    private int num;
    private char op;
    private boolean control;
    public Item(int n) {
        num = n;
        control = true;
    }
    public Item(char o) {
        op = o;
        control = false;
    }
    public boolean getControl() {
        return control;
    }
    public Item getVal() {
        int var = control ? getNum() : getOp();
        return new Item(var);
    }
    public char getOp() {
        return op;
    }
    public int getNum() {
        return num;
    }
    @Override
    public String toString() {
        if(control) {
            return Integer.toString(num);
        } else {
           String s = "";
           s += op;
           return s;
        }
    }
}
