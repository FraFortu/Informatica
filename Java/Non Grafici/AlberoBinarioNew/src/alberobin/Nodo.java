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
public class Nodo <T> /*implements Comparable <T>*/ {
	T info;
	Nodo left;
	Nodo right;
	public Nodo(T info, Nodo left, Nodo right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
	/*@Override
	public int compareTo(T o) {		
		if(info.equals(o)) {
			return 0;
		} else if() {
			
		}
	}*/
	public boolean isEmpty() {
            try {
                return info == null && left == null && right == null;
            } catch (NullPointerException ex) {
                return true;
            }
	}
}
