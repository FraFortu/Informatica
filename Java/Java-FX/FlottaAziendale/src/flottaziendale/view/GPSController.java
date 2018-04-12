/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flottaziendale.view;

import java.util.ArrayList;
import java.util.Date;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

/**
 *
 * @author FortuF100
 */
public class GPSController extends Thread {

    private GridPane list;
    private RilevatoreController controller;

    public GPSController(RilevatoreController c) {
        this.list = c.getGrid();
        this.controller = c;
    }

    @Override
    public void run() {
        while (! this.isInterrupted()) {
            for (int i = 0; i < list.getChildren().size(); i++) {
                if (i % 2 == 0) {
                    Slider s = (Slider) list.getChildren().get(i);
                    s.setValue(controller.getRilevatore().getVeicolo(i / 2).getPosX());
                } /*else if (i % 3 == 2) {
                    Label l = (Label) list.getChildren().get(i);
                    l.setText("Ultima posizione rilevata: " + new Date());
                }*/
            }
        }
    }
}
