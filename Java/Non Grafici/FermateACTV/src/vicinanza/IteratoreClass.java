/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vicinanza;

/**
 *
 * @author francesco.fortunato
 */
public class IteratoreClass <T> implements Iteratore {
	private Lista contenitore;
	private NodoConc element;
	public IteratoreClass(Lista l) {
		contenitore = l;
		goFirst();
	}
	@Override
	public boolean inside() {
		return element != null;
	}
	@Override
	public T current() {
		if(inside()) return (T)element.info;
                else return (T)"Not inside";
	}
	@Override
	public void goNext() {
		if(inside()) element = element.next;
	}
	@Override
	public void goFirst() {
		element = contenitore.testa;
	}
	
}
