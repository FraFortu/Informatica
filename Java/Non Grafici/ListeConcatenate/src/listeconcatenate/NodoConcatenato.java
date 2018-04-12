/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeconcatenate;

/**
 *
 * @author FortuF100
 */
public class NodoConcatenato <T> {
    T info;
    NodoConcatenato next;
    NodoConcatenato(T info, NodoConcatenato next) {
        this.info=info;
        this.next=next;
    }
    public T getInfo() {
        return info;
    }
    public void setNext(NodoConcatenato next) {
        this.next=next;
    }
	public NodoConcatenato getNext() {
		return next;
	}
}
