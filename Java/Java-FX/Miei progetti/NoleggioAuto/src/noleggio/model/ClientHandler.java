/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author FortuF100
 */
public class ClientHandler extends Thread {
    
    private AutoNoleggio autoNoleggio;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    public ClientHandler(AutoNoleggio noleggio, Socket socket) {
        autoNoleggio = noleggio;
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
        } catch(IOException ex) {}
    }
    @Override
    public void run() {
        try {
            /*String arrivo = in.readLine();
            int indexSupport = arrivo.indexOf(" ", 11);
            String nome = arrivo.substring(11, indexSupport);
            String cognome = arrivo.substring(indexSupport + 1, 
                    arrivo.indexOf(" ", indexSupport + 1));  
            indexSupport = arrivo.lastIndexOf(" "); 
            String indirizzo = arrivo.substring(indexSupport + 1); 
            out.println("Benvenuto nel nostro autonoleggio : " + 
                    nome + " " + cognome + " da " + indirizzo + "\n");
            out.println("Quale auto vuoi noleggiare?\n ");*/
            String marca = in.readLine();
            //System.out.println("Marca " + marca);
            String modello = in.readLine(); 
            String found = autoNoleggio.search(marca, modello);
            /*if(! found.isEmpty()) {
                out.println("Abbiamo trovato le seguenti auto\n");*/
            out.println(found);
            /*} else {
                out.println("Non abbiamo trovato auto "
                        + "corrispondenti alla tua ricerca!\n");
                out.println("\n");
            }*/
            String autoScelta = in.readLine();
            autoNoleggio.choice(autoScelta);
        } catch (IOException ex) {
        } 
    }
}
