/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizi;

/**
 *
 * @author francesco.fortunato
 */
public class Nodo <T> {
	protected T info;
	protected Nodo left;
	protected Nodo right;
	public Nodo(T info, Nodo left, Nodo right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
        public boolean isEmpty() {
		return info == null && left == null && right == null;
	}
}
