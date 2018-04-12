/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizi;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author PS03
 */
public class Mappa {
	final int ID = 0;
	final int NAME = 2;
	final int LATITUDE = 4;
	final int LONGITUDE = 5;
	Lista<PuntoMappa> mappa;
	public void load(String fileName) throws FileNotFoundException {
		mappa = new Lista();
		File in = new File(fileName);
		Scanner input = new Scanner(in);
		while(input.hasNextLine()) {
			String s = input.nextLine();
			String[] punto = s.split(",");
			try {
				int id = Integer.parseInt(punto[ID]);
				String name = punto[NAME];
				double lat = Double.parseDouble(punto[LATITUDE]);
				double lon = Double.parseDouble(punto[LONGITUDE]);
				mappa.add(new PuntoMappa(id,name,lat,lon));
			} catch(NumberFormatException ex) {
				System.out.println("Riga non valida " + punto[NAME]);
			}
			//questo try-catch controlla che non siano avvenute eccezioni nel controllo
			//delle stringhe da assegnare a PuntoMappa perciò se trova un'eccezione per il formato della variabile
			//salta quella riga senza aggiungerla alla lista
		}
	}
	public PuntoMappa search(double lat, double lon) {
		PuntoMappa vicino = mappa.testa.info; 
		double distanzaMinima = Double.MAX_VALUE;
		for(Iteratore<PuntoMappa> stop = mappa.newIterator(); stop.inside(); stop.goNext()) {
			double distanzaElemento;
			distanzaElemento = stop.current().distance(lat, lon); //distanza totale pitagorica
			if(distanzaElemento <= distanzaMinima) {
				distanzaMinima = distanzaElemento; 
				//controllo distanza in cui vengono salvate la nuova distanza minima
				//ma soprattutto il PuntoMappa più vicino
				vicino = stop.current();
			}
		}
		return vicino;
	}
	public AlberoBinRicerca ordina() {
		AlberoBinRicerca b = new AlberoBinRicerca();
		for(Iteratore<PuntoMappa> i = mappa.newIterator(); i.inside(); i.goNext()) {
			b.insert(i.current());
			//System.out.println(i.current());
		} 
		return b;
	}
}
