/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author FortuF100
 */
public class Coniglietto {
    
    private int[] vettore;
    private File in;
    
    public static void main(String[] args) {
        Coniglietto c = new Coniglietto("input.txt");
        System.out.println(Arrays.toString(c.vettore));
        System.out.println(Arrays.toString(c.neverReachedPositions()));
    }
    
    public Coniglietto(String file) {
        in = new File(file);
        try {
            Scanner s = new Scanner(in);
            int length = s.nextInt();
            vettore = new int[length];
            int i = 0;
            while(s.hasNext() && i < length) {
                vettore[i++] = s.nextInt();
            }
        } catch (FileNotFoundException ex) {
        }    
    }
    
    public Object[] getReachedPositions() {
        int position = 1;
        boolean hasAlreadyBeenThis = false;
        ArrayList<Integer> alreadyReached = new ArrayList();
        while(! hasAlreadyBeenThis) {
            alreadyReached.add(position);
            position = (position + vettore[position - 1]) % vettore.length + 1;
            for(int i = 0; i < alreadyReached.size(); i++) {
                if(position == alreadyReached.get(i)) {
                    hasAlreadyBeenThis = true;
                    break;
                }
            }
        }
        return alreadyReached.toArray();
    }
    
    public int[] neverReachedPositions() {
        Object[] reached = getReachedPositions();
        int[] neverReached = new int[vettore.length - reached.length];
        int pos = 0;
        for(int i = 1; i <= vettore.length; i++) {
            for(int j = 0; j < reached.length; j++) {
                if(i == (int) reached[j]) {
                    break;
                }
                if(j == reached.length - 1) {
                    neverReached[pos++] = i;
                }
            }
        }
        return neverReached;
    }
    
    public int[] vector() {
        return vettore;
    }
}
