/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author francesco.fortunato
 */
public class PilaIterabile <T> implements IPila {
	private Nodo <T> testa;
	public PilaIterabile() {
		testa = new Nodo(null, null);
	}
	@Override
	public boolean isEmpty() {
		return testa == null;
	}
	
	@Override
	public void push(Object info) {
		if(isEmpty())
			testa = new Nodo(info, null);
		else {
			testa = new Nodo(info, testa);
		}
	}
	
	@Override
	public Nodo pop() {
            Nodo out = testa;
		if(! isEmpty()) {
                    testa = testa.next;
		}
		return out;
	}
	@Override
	public Nodo top() {
		if(isEmpty()) return null;
		return testa;
	}
	public Nodo bottom() {
		Nodo bottom = testa;
		while(bottom.next != null) {
			bottom = bottom.next;
		}
		return bottom;
	}
	public Iterator newIterator() {
		return new IteratorePila(this);
	}
}
