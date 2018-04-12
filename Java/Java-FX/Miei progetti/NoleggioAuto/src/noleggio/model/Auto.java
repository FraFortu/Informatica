/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author FortuF100
 */
public class Auto {
    private StringProperty marca;
    private AutoNoleggio noleggiatore;
    private StringProperty modello;
    public Auto(String marca, String modello) {
        this.marca = new SimpleStringProperty(marca);
        this.modello = new SimpleStringProperty(modello);
    }
    public void setNoleggiatore(AutoNoleggio noleggiatore) {
        this.noleggiatore = noleggiatore;
    }
    public StringProperty getMarcaProperty() {
        return marca;
    }
    public StringProperty getModelloProperty() {
        return modello;
    }
    public String getMarca() {
        return marca.get();
    }
    public String getModello() {
        return modello.get();
    }
    @Override
    public String toString() {
        return marca.get() + " " + modello.get();
    }
}
