/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flottaziendale.model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author FortuF100
 */
public class Rilevatore {

    /*public static void main(String[] args) {
        Rilevatore r = new Rilevatore();
        byte[] ciao = s.getBytes();
        try {
            DatagramPacket packet = new DatagramPacket(ciao, ciao.length, InetAddress.getLocalHost(), 1050);
            //r.add();
            //r.add();
            /*for(int i = 0; i < r.veicoli.size(); i++) {
            r.veicoli.get(i).start();
            }*/
            /*r.socket.send(packet);
            r.socket.receive(packet);
            System.out.println(Arrays.toString(packet.getData()));
        } catch (UnknownHostException ex) {
        } catch (IOException ex) {
        }
    }*/
    private DatagramSocket socket;
    private DatagramPacket dati;
    private ArrayList<Veicolo> veicoli;

    public Rilevatore() {
        try {
            socket = new DatagramSocket();
            veicoli = new ArrayList();
        } catch (SocketException ex) {
        }
    }

    public void add(Veicolo v) {
        veicoli.add(v);
        veicoli.get(veicoli.size() - 1).start();
        byte[] id = veicoli.get(veicoli.size() - 1).getIdName().getBytes();
        byte[] posX = Double.toString(veicoli.get(veicoli.size() - 1).getPosX())
                .getBytes();
        byte[] posY = Double.toString(veicoli.get(veicoli.size() - 1).getPosY())
                .getBytes();
        byte[] dati = new byte[id.length + posX.length + posY.length];
        int i;
        for(i = 0; i < id.length; i++) {
            dati[i] = id[i];
        }
        int k = 0; int j;
        for(j = i; j < posX.length; j++) {
            dati[j] = id[k++];
        }
        k = 0;
        for(i = j; i < posY.length; i++) {
            dati[i] = id[k++];
        }
        try {
            DatagramPacket packet = new DatagramPacket
                (dati,dati.length,InetAddress.getLocalHost(),1050);
            socket.send(packet);
        } catch (UnknownHostException ex) { } catch (IOException ex) {} 
    }

    public Veicolo getVeicolo(int i) {
        return veicoli.get(i);
    }
    
    public int getSize() {
        return veicoli.size();
    }
}
