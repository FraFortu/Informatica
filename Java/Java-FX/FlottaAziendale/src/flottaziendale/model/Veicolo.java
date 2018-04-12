package flottaziendale.model;

import java.util.Random;

public class Veicolo extends Thread {

    private double posX;
    private double posY;
    private String id;
    private int timeout;
    private final Random generator = new Random();
    private int[] whereToGo = new int[generator.nextInt(1000)];

    public Veicolo(String s) {
        id = s;
        timeout = 600;
        posX = 45.05; posY = 12.0;
        for(int i = 0; i < whereToGo.length; i++) {
            int n = generator.nextInt(2);
            if(n == 0) whereToGo[i] = 1;
            else whereToGo[i] = -1;
        }
    }
    
    public Veicolo() {
        this("");
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - start > timeout) {
                setPosX();
                setPosY();
                start = System.currentTimeMillis();
            }
        }
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setPosX() {
        posX = (posX - 45.05 + (0.01 * 
                whereToGo[generator.nextInt(whereToGo.length)]) % 0.6 + 45.05);
    }
    
    public void setPosX(double x) {
        posX = x;
    }

    public void setPosY() {
        posY = (posY - 11.88 + (0.01 * 
                whereToGo[generator.nextInt(whereToGo.length)]) % 0.6 + 11.88);
    }
    
    public void setPosY(double y) {
        posY = y;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
    public String getIdName() {
        return id;
    }
    /*@Override
        public void run() {
            while(true) {
                posX = generator.nextInt(60) / 10 + 45.05;
                posY = generator.nextInt(50) / 10 + 11.88;
                String send = posX + " " + posY + " " + id;
                byte[] bytes = send.getBytes();
                DatagramPacket pack = new DatagramPacket(bytes, bytes.length);
                try {
                    pack.setAddress(InetAddress.getLocalHost());
                    rilevatore.position = pack;
                } catch (UnknownHostException ex) {}
                try {
                    socket.send(position);
                    System.out.println("Inviato");
                } catch (IOException ex) {
                }
            }
        }*/
}
