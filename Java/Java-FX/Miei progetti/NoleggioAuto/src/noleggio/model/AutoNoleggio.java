/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author FortuF100
 */
public class AutoNoleggio {

    protected ArrayList<Auto> parcoMacchine;
    protected ArrayList<Boolean> state;

    public AutoNoleggio() {
        parcoMacchine = new ArrayList();
        state = new ArrayList();
    }
    
    public void addListener() {
        new Listener(this).start();
    }
    
    public void add(Auto a) {
        this.parcoMacchine.add(a);
        state.add(Boolean.TRUE);
    }
    public ObservableList<Auto> getParco() {
        ObservableList<Auto> auto = FXCollections.observableArrayList(parcoMacchine);
        return auto;
    }
    public String search(String marca, String modello) {
        int j;
        ArrayList<String> autoTrovate = new ArrayList();
        for(int i = 0; i < parcoMacchine.size(); i++) {
            if(modello.equals(parcoMacchine.get(i).getModello()))
                autoTrovate.add(parcoMacchine.get(i).toString());
        }
        for(int i = 0; i < parcoMacchine.size(); i++) {
            if(marca.equals(parcoMacchine.get(i).getMarca())) {
                for(j = 0; j < autoTrovate.size(); j++) {
                    if(autoTrovate.get(j).equals(parcoMacchine.get(i).toString())) {
                        break;
                    }
                }
                if(j == autoTrovate.size())
                    autoTrovate.add(parcoMacchine.get(i).toString());
            }
        }
        //System.out.println(autoTrovate.toString());
        return autoTrovate.toString();
    }
    public void choice(String auto) {
        for(int i = 0; i < parcoMacchine.size(); i++) {
            if(auto.equals(parcoMacchine.get(i).toString())) {
                state.set(i, Boolean.FALSE);
            }
        }
    }
    public ArrayList<Boolean> getStates() {
        return state;
    }
}
