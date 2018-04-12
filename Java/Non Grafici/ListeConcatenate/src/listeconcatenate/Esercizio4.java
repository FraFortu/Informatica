/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeconcatenate;
import java.util.Scanner;
/**
 *
 * @author francesco.fortunato
 */
public class Esercizio4 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Scanner input = new Scanner(System.in);
                //boolean guardia = true;
                System.out.println("Inserisci qualcosa");
                String s = "";
                /*while(guardia) {
                    System.out.println("Vuoi inserire qualcosa?");
                    if(input.nextLine().equals("no")) guardia = false;
                    else {
                        System.out.println("Inserisci qui sotto.");
                        s += input.nextLine()+" ";
                    }
                }*/
                ListaConcatenata y = createAListFromAString(input.nextLine());
                System.out.println(y.size());
                System.out.println(y.toString());
		
	}
	static ListaConcatenata createAListFromAString(String s) {
            int i = 0;
            int spazi = 0;
            ListaConcatenata nuova = new ListaConcatenata();
            while(i < s.length()) {
                if(s.charAt(i)==' ') {
                    nuova.addTail(s.substring(spazi,i));
                    spazi = i;
                }
                if(i == s.length()-1) {
                    nuova.addTail(s.substring(spazi,i+1));
                }
                i++;
            }
            return nuova;
        }
}
