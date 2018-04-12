/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vicinanza;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author PS03
 */
public class Mappa {
	Lista<PuntoMappa> mappa;
	public void load(String fileName) throws FileNotFoundException {
		mappa = new Lista();
		File in = new File(fileName);
		Scanner input = new Scanner(in);
		while(input.hasNextLine()) {
			try {
				mappa.add(new PuntoMappa(input.nextLine()));
			} catch(NumberFormatException ex) {
			}
			//questo try-catch controlla che non siano avvenute eccezioni nel controllo
			//delle stringhe da assegnare a PuntoMappa perciò se trova un'eccezione per il formato della variabile
			//salta quella riga senza aggiungerla alla lista
		}
	}
	public PuntoMappa search(double lat, double lon) {
		double distanzaMinima = Double.MAX_VALUE; //distanza minima parte con un valore altissimo così verrà subito modificata
		PuntoMappa vicino = mappa.testa.info;               
		for(Iteratore<PuntoMappa> stop = mappa.newIterator(); stop.inside(); stop.goNext()) {
			double distanzaElemento;
			double latDistanza = lat - stop.current().lat_zone; //distanza latitudini
			double lonDistanza = lon - stop.current().lon_zone; //distanza longitudini
			distanzaElemento = Math.sqrt(latDistanza * latDistanza + lonDistanza * lonDistanza); //distanza totale pitagorica
			if(distanzaElemento < distanzaMinima) {
				distanzaMinima = distanzaElemento; 
				//controllo distanza in cui vengono salvate la nuova distanza minima
				//ma soprattutto il PuntoMappa più vicino
				vicino = (PuntoMappa)stop.current();
			}
		}
		return vicino;
	}
}
