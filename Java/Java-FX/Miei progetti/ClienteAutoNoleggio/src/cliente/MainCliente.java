/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cliente.view.ClientInterfaceController;
import cliente.view.SceltaMacchinaController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author FortuF100
 */
public class MainCliente extends Application {
    
    private Stage primaryStage;
    private String autoTrovate;
    
    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        
        this.primaryStage.setTitle("Cliente");
        
        setInterface();
        
        this.primaryStage.show();
    }
    
    public void setInterface() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCliente.class.getResource("view/ClienteInterface.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            
            primaryStage.setScene(new Scene(root));
            
            ClientInterfaceController controller = loader.getController();
            controller.setMainCliente(this);
            
        } catch (IOException ex) {
        }
    }
    
    public boolean setSceltaMacchina(String[] infoMacchina) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCliente.class.getResource("view/SceltaMacchina.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Cerca una macchina");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            SceltaMacchinaController controller = loader.getController();
            controller.setMainCliente(this);
            controller.setStage(dialogStage);
            controller.setInfoMacchina(infoMacchina);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOKClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void setAuto(String auto) {
        this.autoTrovate = auto;
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
