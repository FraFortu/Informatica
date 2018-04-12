/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.view;

import cliente.model.Cliente;
import cliente.MainCliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author FortuF100
 */
public class ClientInterfaceController {
    private Cliente cliente;
    private MainCliente mainCliente;
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField cognome;
    
    @FXML
    private TextField indirizzo;
    
    @FXML
    private Button cerca;
    
    @FXML
    private void initialize() {
    }
    
    public void setMainCliente(MainCliente main) {
        mainCliente = main;
    }
    
    @FXML
    private void cercaButton() {
        String[] infoMacchina = new String[2];
        if(mainCliente.setSceltaMacchina(infoMacchina)) {
            cliente = new Cliente(nome.getText(), cognome.getText(), indirizzo.getText());
            cliente.affare(infoMacchina[0], infoMacchina[1]);
            Stage carChoiceStage = new Stage();
            carChoiceStage.setTitle("Choose the car");
            carChoiceStage.initModality(Modality.WINDOW_MODAL);
            carChoiceStage.initOwner(this.mainCliente.getPrimaryStage());
            
            ListView list = new ListView();
            Button ok = new Button("OK");
            ObservableList cars = FXCollections.observableArrayList(cliente.createCarList());
            Pane layout = new Pane();
            
            list.setItems(cars);
            ok.setLayoutX(200);
            ok.setLayoutY(300);
            ok.setOnAction(value -> {
                list.getSelectionModel().selectedItemProperty().
                    addListener(listener -> {
                        
                    });
                this.cliente.noleggiaAuto(list.getSelectionModel().getSelectedItem().toString());
                carChoiceStage.close();
            });
            layout.getChildren().add(list);
            layout.getChildren().add(ok);
            
            Scene scene = new Scene(layout);
            carChoiceStage.setScene(scene);
            carChoiceStage.showAndWait();
        }
    }
}
