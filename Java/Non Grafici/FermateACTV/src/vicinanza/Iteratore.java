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
public interface Iteratore <T> {
	boolean inside();
	T current();
	void goNext();
	void goFirst();
}
