/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.model;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author FortuF100
 */
public class Listener extends Thread {
    private AutoNoleggio noleggio;
    public Listener(AutoNoleggio noleggio) {
        this.noleggio = noleggio;
    }
    @Override
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(8000);
                try {
                    while(true) {
                        new ClientHandler(noleggio, listener.accept()).start();
                    } 
                } finally {
                    listener.close();
                }
        } catch (IOException ex) {
        }
    }
}
