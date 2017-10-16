/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

import java.util.ArrayList;

/**
 *
 * @author FortuF100
 */
public class RPN {
    protected ArrayList<Item> exp;
    public RPN() {
        exp = new ArrayList<>();
    }
    public void append(int n) {
        exp.add(new Item(n));
    }
    public void append(char o) {
        exp.add(new Item(o));
    }
    public NodoConcatenato value() {
        Pila<Integer> p  = new Pila<>();
        for(int i = 0; i < exp.size(); i++) {
            if(exp.get(i).getControl() == false) {
                int op2 = (int) p.pop().getInfo();
                int op1 = (int) p.pop().getInfo(); 
                int risultato;
                switch (exp.get(i).getOp()) {
                    case '+':
                        risultato = op1 + op2;
                        break;
                    case '-':
                        risultato = op1 - op2;
                        break;
                    case '*':
                        risultato = op1 * op2;
                        break;
                    case '/':
                        risultato = op1 / op2;
                        break; 
                    default:
                        risultato = 0;
                        break;
                }
                p.push(risultato);
            } else 
                p.push(exp.get(i).getNum());
        }
        return p.top();
    }
    public void riempi(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' ') {
                char c = s.charAt(i-1);
                if(c == '+' || c == '-' || c == '*' || c == '/') {
                    exp.add(new Item(c));
                } else {
                    for (int pos = i - 1; pos >= 0; pos--) {
                        if (s.charAt(pos) == ' ') {
                            String temp = s.substring(pos + 1, i);
                            exp.add(new Item(Integer.parseInt(temp)));
                            break;
                        } else if(pos == 0) {
                            String temp = s.substring(pos, i);
                            exp.add(new Item(Integer.parseInt(temp)));
                            break;
                        }
                    }
                }
            } else if (i == s.length() - 1) {
                exp.add(new Item(s.charAt(i)));
            }
        }
    }
}
