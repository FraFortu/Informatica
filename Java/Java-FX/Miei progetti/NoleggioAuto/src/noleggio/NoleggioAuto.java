/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import noleggio.model.Auto;
import noleggio.model.AutoNoleggio;
import noleggio.view.AutoNoleggioController;

/**
 *
 * @author FortuF100
 */
public class NoleggioAuto extends Application {
    
    private Stage primaryStage;
    private AutoNoleggio parcoMacchine = new AutoNoleggio();
    
    public NoleggioAuto() {
        parcoMacchine.addListener();
        parcoMacchine.add(new Auto("Ferrari","F40"));
        parcoMacchine.add(new Auto("Mercedes","LGA"));
        parcoMacchine.add(new Auto("Fiat","Panda"));
        parcoMacchine.add(new Auto("Alfa Romeo","Stelvio"));
        parcoMacchine.add(new Auto("Volkswagen","Polo"));
        parcoMacchine.add(new Auto("Ford","Focus"));
        parcoMacchine.add(new Auto("Mini","Cooper"));
        parcoMacchine.add(new Auto("Fiat","500"));
        parcoMacchine.add(new Auto("Fiat","Punto"));
        parcoMacchine.add(new Auto("Renault","Scenic"));
        parcoMacchine.add(new Auto("Citroen","C4"));
        parcoMacchine.add(new Auto("Audi","A1"));
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        
        this.primaryStage.setOnCloseRequest(value -> System.exit(0));
        
        this.primaryStage.setTitle("Noleggio");
        
        setAutoNoleggio();
    }
    public void setAutoNoleggio() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NoleggioAuto.class.getResource(
                    "view/AutoNoleggio.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            
            primaryStage.setScene(new Scene(root));
            
            AutoNoleggioController controller = loader.getController();
            controller.setMainNoleggio(this);
        
            this.primaryStage.show();
            
        } catch(IOException ex) {
        }
    }
    public AutoNoleggio getParco() {
        return parcoMacchine;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
