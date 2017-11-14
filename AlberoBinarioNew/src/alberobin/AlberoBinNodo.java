/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobin;

/**
 *
 * @author francesco.fortunato
 */
public class AlberoBinNodo <T> {
	protected Nodo <T> rad;//è un nodo o un albero??
	public AlberoBinNodo(Nodo left, T info, Nodo right) {
                this();
                try {
                    rad.info = info;
                    rad.left = left;
                    rad.right = right;
                } catch (NullPointerException ex) {                 
                }
                
	}
        public AlberoBinNodo() {
            rad = new Nodo(null, null, null);
        }
	public boolean isEmpty() {
            try {
		return rad.info == null && rad.left == null && rad.right == null;
            } catch(NullPointerException ex) {
                return true;
            }
	}
	public Nodo left() {
		return rad.left; //è un nodo o un albero??
	}
	public Nodo right() {
		return rad.right;//è un nodo o un albero??
	}
	/*public Nodo delete(T object, Nodo n) {
		if(! n.info.equals(object)) {
                    delete(object, n.left);
                    delete(object, n.right);
		} else {
                    return n;
                }
                Nodo c = n;
                n = null;
		return c;
	}*/
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
		/*public void BinarySearchTree(Nodo<Integer> n, Lista<Integer> l, int dove) {
			if(n.isEmpty()) {
				n.info = l.get(dove);
			} else if(l.get(dove) < n.info) {
				BinarySearchTree(n.left,l,dove + 1);
			} else {
				BinarySearchTree(n.right,l,dove + 1);
			}
		}*/
}
