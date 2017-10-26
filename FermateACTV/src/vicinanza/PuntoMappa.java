/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vicinanza;


/**
 *
 * @author PS03
 */
public class PuntoMappa {
	final int stop_id; //un intero per il codice della fermata è personalmente opportuno
	String stop_name; //una stringa per il nome
	final double lat_zone; //due variabili double per latitudine e longitudine
	final double lon_zone;
	//tutte le variabili sono final perchè non possono essere mai modificate nel corso del programma
	//@stop_name è già immutabile essendo una stringa
	//le variabili sono pubbliche per essere visualizzate a proprio piacimento
	public PuntoMappa(String line) {
		String[] riga = line.split(",");
		stop_id = Integer.parseInt(riga[0]);
		stop_name = riga[2];	
		lat_zone = Double.parseDouble(riga[4]);
		lon_zone = Double.parseDouble(riga[5]);
	}
	//il costruttore assegna alle proprietà i vari valori dividendo ogni riga in base alle virgole
}
