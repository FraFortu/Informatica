/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobin;

import java.util.Random;

/**
 *
 * @author francesco.fortunato
 */
public class Test3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		AlberoBinRicerca b = new AlberoBinRicerca();
                for(int i = 0; i < 9; i ++) {
                    int n = new Random().nextInt(20);
                    b.insert(n);
                   // System.out.println("Inserito il numero " + n);
                }
		Lista l = new Lista();
		b.visitaSimmetrica(l, b.rad);
		System.out.println(l.toString());
	}
	
}
