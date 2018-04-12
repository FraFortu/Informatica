/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flottaziendale.view;

import flottaziendale.FlottaAziendale;
import flottaziendale.model.Rilevatore;
import flottaziendale.model.Veicolo;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

/**
 *
 * @author FortuF100
 */
public class RilevatoreController {

    @FXML
    private GridPane list;

    @FXML
    private Button addVehicle;

    private Rilevatore rilevatore = new Rilevatore();
    private int row;
    private int column;
    private FlottaAziendale flotta;
    private GPSController gps;

    public RilevatoreController() {
    }

    @FXML
    protected void initialize() {
        row = column = 0;
    }

    @FXML
    private void clickAddVehicle() {
        Veicolo v = new Veicolo();
        boolean isOK = flotta.manageNewVehicle(v);
        if (isOK) {
            rilevatore.add(v);
            gps.interrupt();
            Slider s = new Slider();
            s.setMax(45.65);
            s.setMin(45.05);
            s.setValue(rilevatore.getVeicolo(rilevatore.getSize() - 1).getPosX());
            Label id = new Label(rilevatore.getVeicolo(rilevatore.getSize() - 1).getIdName());
            //Label time = new Label("Ultima Posizione: " + new Date());
            list.add(s, column, row);
            list.add(id, ++column, row);
            //list.add(time, ++column, row);
            column = 0;
            row++;
            gps = new GPSController(this);
            gps.start();
        }
    }

    public GridPane getGrid() {
        return list;
    }

    public Rilevatore getRilevatore() {
        return rilevatore;
    }

    public void setFlotta(FlottaAziendale f) {
        this.flotta = f;
    }
    
    public void setGPS(GPSController gps) {
        this.gps = gps;
    } 
}
