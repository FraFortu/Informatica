package flottaziendale.model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class Server {
    
    private DatagramSocket server;
    private ArrayList<String> pacchetti = new ArrayList();

    public Server() {
        try {
            server = new DatagramSocket(1050);
        } catch (SocketException ex) {
        }
    }

    public void receive() {
        while (true) {
            try {
                byte[] receive = new byte[1000];
                DatagramPacket packet = new DatagramPacket(
                        receive,receive.length,InetAddress.getLocalHost(),1050);
                server.receive(packet);
                receive = packet.getData();
                String s = new String(receive);
                this.pacchetti.add(s);
                confirmMessage();
            } catch (IOException ex) {
                System.out.println("Problems during receiving ");
                ex.printStackTrace();
            }
        }
    }

    public void confirmMessage() {
        try {
            String s = "Confirmed";
            byte[] message = s.getBytes();
            DatagramPacket p = new DatagramPacket(message, message.length);
            p.setAddress(InetAddress.getLocalHost());
            server.send(p);
        } catch (IOException ex) {
            System.out.println("Problems : ");
            ex.printStackTrace();
        }
    }
    
    public ArrayList<String> getPAcchetti() {
        return pacchetti;
    }
}
