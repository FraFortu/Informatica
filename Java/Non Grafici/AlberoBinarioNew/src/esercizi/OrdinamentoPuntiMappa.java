/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizi;

import java.io.FileNotFoundException;

/**
 *
 * @author francesco.fortunato
 */
public class OrdinamentoPuntiMappa {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Mappa m = new Mappa();
		m.load("stops.csv");
		AlberoBinRicerca bin = m.ordina();
		Lista l = new Lista();
		bin.visitaSimmetrica(l, bin.getRad());
		System.out.println(l.toString());
	}
	
}
