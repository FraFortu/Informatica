/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flottaziendale;

import flottaziendale.model.Veicolo;
import flottaziendale.view.GPSController;
import flottaziendale.view.NewVehicleDialogController;
import flottaziendale.view.RilevatoreController;
import flottaziendale.view.ServerController;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

/**
 *
 * @author francesco.fortunato
 */
public class FlottaAziendale extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Vehicles");
        this.primaryStage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(0);
        });
        
        setRilevatore();
        showInterface();

        this.primaryStage.show();
    }

    public void showInterface() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FlottaAziendale.class.getResource("view/Server.fxml"));
			StackPane scene = (StackPane) loader.load();
                        
                        Stage stage = new Stage();
                        stage.setTitle("Server");
			stage.setOnCloseRequest(event -> System.exit(0));
                        //stage.initModality(Modality.WINDOW_MODAL);
                        stage.setScene(new Scene(scene));
                        
			ServerController controller = loader.getController();
			controller.setFlotta(this);
                        
                        stage.show();
		} catch (IOException ex) {
		}
	}
    public void setRilevatore() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FlottaAziendale.class.getResource("view/Rilevatore.fxml"));
            AnchorPane ril = (AnchorPane) loader.load();

            primaryStage.setScene(new Scene(ril));

            RilevatoreController controller = loader.getController();
            controller.setFlotta(this);

            GPSController state = new GPSController(controller);
            controller.setGPS(state);
            state.start();
            
        } catch (IOException ex) {
        }
    }

    public boolean manageNewVehicle(Veicolo v) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FlottaAziendale.class.getResource("view/NewVehicleDialog.fxml"));
            AnchorPane window = (AnchorPane) loader.load();

            Stage dialog = new Stage();
            dialog.setTitle("New Vehicle");
            dialog.initOwner(this.primaryStage);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setScene(new Scene(window));

            NewVehicleDialogController controller = loader.getController();
            controller.setStage(dialog);
            controller.setVehicle(v);

            dialog.showAndWait();
            return controller.isOkClicked();
        } catch (IOException ex) {
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
