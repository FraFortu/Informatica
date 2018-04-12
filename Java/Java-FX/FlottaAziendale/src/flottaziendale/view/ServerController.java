/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flottaziendale.view;

import flottaziendale.FlottaAziendale;
import flottaziendale.model.Server;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author francesco.fortunato
 */
public class ServerController {
	@FXML
	private VBox scene;
        
        @FXML
        private GridPane list;
	
	private FlottaAziendale flotta;
	protected Server server;
        private Updater updater;
	
	public ServerController() {
	}
	
	@FXML
	private void initialize() {
		server = new Server();
	}
	
	public void setFlotta(FlottaAziendale f) {
		this.flotta = f;
	}
	
	public void setVehicles() {
            
		
	}
        public GridPane getGrid() {
            return list;
        }
	
}
class Updater extends Thread {
    private ServerController controller;
    public Updater(ServerController c) {
        this.controller = c;
    }
    @Override
    public void run() {
        while(this.isAlive()) {
            controller.server.receive();
            for(int i = 0; i < controller.getGrid().getChildren().size(); i++) {
                
            }
        }
    }
}
