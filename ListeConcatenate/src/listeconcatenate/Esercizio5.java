/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeconcatenate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author FortuF100
 */
public class Esercizio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(""
                + "C:\\Users\\Francesco\\Desktop\\Scuola\\Triennio\\4IC 2017 2018\\Informatica\\Java\\ListeConcatenate\\src\\listeconcatenate\\File.txt");
        Scanner input = new Scanner(f);
        ListaConcatenata lista = crea(input);
        int size = lista.size();
        int j = 0;
        while(j < size) {
            String t = (String)lista.get(j);
            if(t.contains("@")) {
                System.out.println("C'è un indirizzo: "+t);
            }
            j++;
        }
    }
    static ListaConcatenata crea(Scanner input) {
        ListaConcatenata lista = new ListaConcatenata();
        int i;
        String s = input.nextLine();
        int virgole;
        do {
            i = 0;
            String temp = s;
            while(temp.contains(",")) { 
                    virgole = temp.indexOf(",");
                    i=0;
                    lista.addTail(temp.substring(i, virgole));
                    i = virgole + 1;
                    virgole = temp.length();
                    temp = temp.substring(i,virgole);
            }
            if(temp.contains(".")) {
                i = temp.indexOf(".");
                lista.addTail(temp.substring(0,i));
                break;
            }
        } while(input.hasNext());
        return lista;
    }
    
}
