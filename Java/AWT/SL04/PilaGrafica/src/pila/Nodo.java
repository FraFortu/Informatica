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
public class Nodo <T> {
	T info;
	Nodo next;
	public Nodo(T info, Nodo next) {
		this.info = info;
		this.next = next;
	}
}
