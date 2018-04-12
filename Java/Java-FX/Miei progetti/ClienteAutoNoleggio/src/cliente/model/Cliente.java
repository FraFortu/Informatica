/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author FortuF100
 */
public class Cliente {

    private String nome;
    private String cognome;
    private String indirizzo;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String auto;
    private String marca;
    private String modello;

    public Cliente(String nome, String cognome, String indirizzo) {
        try {
            this.nome = nome;
            this.cognome = cognome;
            this.indirizzo = indirizzo;
            //"192.168.1.173"
            socket = new Socket("192.168.1.173", 8000);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
        }
    }

    public String affare(String marca, String modello) {
        String auto = "";
        try {
            //visualizza welcome
            /*out.print("Salve sono "
                    + nome + " "
                    + cognome + " e vengo da "
                    + indirizzo + "\n");
            String welcome = "";
    
            welcome = in.readLine();
            
            welcome += in.readLine();
            
            System.out.println(welcome);*/
            out.println(marca);
            out.println(modello);
            //modello e marca
            /*String risposta = "";
            risposta = in.readLine();*/
            this.auto = in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            auto = null;
        }
        return auto;
    }
    
    public ArrayList<String> createCarList() {
        ArrayList<String> list = new ArrayList();
        String[] cars = auto.substring(1, auto.length() - 1).split(",");
        list.addAll(Arrays.asList(cars));
        return list;
    }
    public void noleggiaAuto(String auto) {
        out.println(auto);
    }
}
