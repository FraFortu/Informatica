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
public class NodoLista <T> {
    T info;
    NodoLista next;
    NodoLista(T info, NodoLista next) {
        this.info=info;
        this.next=next;
	}
}