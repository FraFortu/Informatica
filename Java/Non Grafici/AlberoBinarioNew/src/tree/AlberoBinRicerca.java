/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import alberobin.Lista;

/**
 *
 * @author francesco.fortunato
 */
public class AlberoBinRicerca <T extends Comparable<T>> {
	protected Nodo<T> radice;
	public AlberoBinRicerca() {
		radice = new Nodo(null, null, null);
	}
	public AlberoBinRicerca(AlberoBinRicerca left, T info, AlberoBinRicerca right) {
		radice.left = left.radice;
		radice.info = info;
		radice.right = left.radice;
	}
	public Nodo getRad() {
		return radice;
	}
	public boolean isEmpty() {
		return radice == null;
	}
	public void insert(T info) {
		Nodo temp = radice;
		if(temp.isEmpty()) {
			temp.info = info;
			return;
		} else while(! temp.isEmpty()) {
			if(temp.left != null && temp.right != null) {
				if(info.compareTo((T) temp.info) < 0) temp = temp.left;
				else temp = temp.right;
			} else if(info.compareTo((T) temp.info) < 0) {
					if(temp.left == null) {
						temp.left = new Nodo(info, null, null);
						return;
					}
					else temp = temp.left;
			} else {
					if(temp.right == null) {
						temp.right = new Nodo(info, null, null);
						return;
					}
					else temp = temp.right;
			}
		}
	}
	public void visitaAnticipata(Lista l, Nodo n) {
            try {
		if(!this.isEmpty()) {
                        l.addTail(n.info);
			visitaAnticipata(l, n.left);
			visitaAnticipata(l, n.right);
		}
            } catch (NullPointerException ex) {
            }                
	}
        public void visitaDifferita(Lista l, Nodo n) {
            try {
                if(!this.isEmpty()) {
                    visitaDifferita(l, n.left);
                    visitaDifferita(l, n.right);
                    l.addTail(n.info);
                }
            } catch (NullPointerException ex) {
            }
            
        }
        public void visitaSimmetrica(Lista l, Nodo n) {
            try {
                if(!n.isEmpty()) {
						visitaSimmetrica(l, n.left);
						l.addTail(n.info);
                        visitaSimmetrica(l, n.right);
                }
            } catch (NullPointerException ex) {
            } 
        }
}
