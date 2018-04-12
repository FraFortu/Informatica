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
public interface Iterator {
	Object current();
	boolean inside();
	void goFirst();
	void goNext();
}
