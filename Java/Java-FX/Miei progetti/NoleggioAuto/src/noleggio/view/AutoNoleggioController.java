/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import noleggio.NoleggioAuto;
import noleggio.model.Auto;

/**
 *
 * @author FortuF100
 */
public class AutoNoleggioController {
    private NoleggioAuto mainNoleggio;
    
    /*@FXML
    private ObservableList<Auto> auto = FXCollections.observableArrayList();
    
    @FXML
    private ObservableList<String> clienti = FXCollections.observableArrayList();*/
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private TableView parcoAuto;
    
    @FXML
    private TableColumn<Auto, String> firstColumn;
    
    @FXML
    private TableColumn<String, String> secondColumn;
    
    @FXML
    private void initialize() {  
        firstColumn.setText("Macchine nell'autonoleggio");
        firstColumn.setCellValueFactory(value -> {
            String car = value.getValue().getMarca() + " " + 
                    value.getValue().getModello();
            return new SimpleStringProperty(car);
        });
        secondColumn.setText("Stato");
        secondColumn.setCellValueFactory(value -> {
            return new SimpleStringProperty();
        });
    }
    
    public void setMainNoleggio(NoleggioAuto main) {
        mainNoleggio = main;
        parcoAuto.setItems(mainNoleggio.getParco().getParco());
    }
    
    /*public void setAutoNoleggio(AutoNoleggio autoNoleggio) {
        this.autoNoleggio = autoNoleggio;
    }*/
    
    
}
