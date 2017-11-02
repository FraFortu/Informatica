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
public class Nodo <T> {
	T info;
	Nodo left;
	Nodo right;
	public Nodo(T info, Nodo left, Nodo right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
}
