/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizi;


/**
 *
 * @author PS03
 */
public class PuntoMappa implements Comparable {
	final int stop_id; //un intero per il codice della fermata è personalmente opportuno
	final String stop_name; //una stringa per il nome
	final double lat_zone; //due variabili double per latitudine e longitudine
	final double lon_zone;
	//tutte le variabili sono final perchè non possono essere mai modificate nel corso del programma
	//@stop_name è già immutabile essendo una stringa
	//le variabili sono pubbliche per essere visualizzate a proprio piacimento
	public PuntoMappa(int id, String name, double lat, double lon) {
		stop_id = id;
		stop_name = name;
		lat_zone = lat;
		lon_zone = lon;
	}
	//il costruttore assegna alle proprietà i vari valori dividendo ogni riga in base alle virgole
	public double distance(double lat, double lon) {
		double distLat = this.lat_zone - lat;
		double distLon = this.lon_zone - lon;
		return Math.sqrt(distLat * distLat + distLon * distLon);
	}
	@Override
	public int compareTo(Object o) {
		PuntoMappa compare = (PuntoMappa) o;
		if(this.lat_zone < compare.lat_zone) return -1;
		else if(this.lat_zone > compare.lat_zone) return 1;
                else if(this.lon_zone < compare.lon_zone) return -1;
                else if(this.lon_zone > compare.lon_zone) return 1;
                else return 0;
	}
	@Override
	public String toString() {
		Double n = lat_zone;
		return n.toString();
	}
}
