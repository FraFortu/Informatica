/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flottaziendale.view;

import flottaziendale.model.Veicolo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author FortuF100
 */
public class NewVehicleDialogController {

    private Stage stage;

    @FXML
    private TextField id;

    @FXML
    private TextField coordinateX;

    @FXML
    private TextField coordinateY;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    private Veicolo veicolo;
    private boolean isOKClicked = false;

    @FXML
    private void initialize() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isOkClicked() {
        return isOKClicked;
    }
    @FXML   
    private void handleOk() {
        if (inputValid()) {
            veicolo.setPosX(Double.parseDouble(coordinateX.getText()));
            veicolo.setPosY(Double.parseDouble(coordinateY.getText()));
            veicolo.setId(id.getText());
            isOKClicked = true;
            stage.close();
        }
    }
    
    @FXML
    private void handleCancel() {
        this.stage.close();
    }

    public void setVehicle(Veicolo v) {
        veicolo = v;
        
        veicolo.setId(v.getIdName());
        veicolo.setPosX(v.getPosX());
        veicolo.setPosY(v.getPosY());
    }

    public boolean inputValid() {
        if(Double.parseDouble(coordinateX.getText()) < 45.05 || 
                Double.parseDouble(coordinateX.getText()) > 45.65) 
            veicolo.setPosX(45.05);
        return true;
    }
}
