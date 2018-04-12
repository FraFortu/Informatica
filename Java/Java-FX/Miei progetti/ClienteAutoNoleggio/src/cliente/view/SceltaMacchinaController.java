/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.view;

import cliente.MainCliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FortuF100
 */
public class SceltaMacchinaController {
    private MainCliente mainCliente;
    private boolean isOKClicked = false;
    private String[] infoMacchina = new String[2];
    private Stage stage;
    
    @FXML
    private Button ok;
    @FXML
    private TextField modello;
    @FXML
    private TextField marca;
    
    
    @FXML
    private void initialize() {
    }    
    
    public void setMainCliente(MainCliente main) {
        this.mainCliente = main;
    }
    public boolean isOKClicked() {
        return isOKClicked;
    }
    @FXML
    private void OKPressed() {
        isOKClicked = true;
        infoMacchina[0] = marca.getText();
        infoMacchina[1] = modello.getText();
        stage.close();
    }
    public void setInfoMacchina(String[] info) {
        this.infoMacchina = info;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
