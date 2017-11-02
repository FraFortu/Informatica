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
public class Test {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		AlberoBin b = new AlberoBin(5, new AlberoBin(2, null, null),
				new AlberoBin(3, new AlberoBin(17, null, null), null));
		Lista[] l = new Lista[3];
                for(int i = 0; i < 3; i++) {
                    l[i] = new Lista();
                }
		visitaAnticipata(l[0],b);
		System.out.println("Visita Anticipata: " + l[0].toString());
                visitaDifferita(l[1],b);
                System.out.println("Visita Differita: " + l[1].toString());
                visitaSimmetrica(l[2],b);
                System.out.println("Visita Simmetrica " + l[2].toString());
	}
	public static void visitaAnticipata(Lista l, AlberoBin b) {
            try {
		if(!b.isEmpty()) {
			l.addTail(b.getInfo());
			visitaAnticipata(l,b.getLeft());
			visitaAnticipata(l,b.getRight());
		}
            } catch (NullPointerException ex) {
            }                
	}
        public static void visitaDifferita(Lista l, AlberoBin b) {
            try {
                if(!b.isEmpty()) {
                    visitaDifferita(l,b.getLeft());
                    visitaDifferita(l,b.getRight());
                    l.addTail(b.getInfo());
                }
            } catch (NullPointerException ex) {
            }
            
        }
        public static void visitaSimmetrica(Lista l, AlberoBin b) {
            try {
                if(!b.isEmpty()) {
                    visitaSimmetrica(l,b.getLeft());
                    l.addTail(b.getInfo());
                    visitaSimmetrica(l,b.getRight());
                }
            } catch (NullPointerException ex) {
            } 
        }
}
