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
public class Pila <T>{
    private NodoConcatenato<T> pila;
    private int pointer;
    public Pila() {
        pila=new NodoConcatenato(null,null);
		pointer=0;
    }
    public void push(T el) {
		NodoConcatenato testa=new NodoConcatenato(el,null);
        if(isEmpty()) pila=testa;
        else {
			testa.setNext(pila);
			pila=testa;
		}
		pointer++;       
    }
    public NodoConcatenato pop() {
        if(!isEmpty()) {
			NodoConcatenato toExit=pila;
			pila=pila.getNext();
			pointer--;
			return toExit;
		}
        else return null;
    }
    public NodoConcatenato top() {
        if(!isEmpty()) return pila;
        else return null;
    }
    public boolean isEmpty() {
        return pointer==0;
    }
}
