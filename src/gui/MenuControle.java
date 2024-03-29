package gui;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.ListaControleDepartamentos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MenuControle implements Initializable {

	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemDepartamentos;
	@FXML
	private MenuItem menuSobre;
	
	@FXML
	public void onMenuItemVendedorAcao() {
		System.out.println("onMenuItemVendedorAcao");
	}
	
	@FXML
	public void onMenuItemDepartamentosAcao() {
		loadView(" /gui.util/Lista de Departamento.fxml"); 
		
	}
	@FXML
	public void onMenuItemSobreAcao() {
		loadView(" /gui.util/Sobre.fxml");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro ao carregar a p�gina de visualiza��o", e.getMessage(), AlertType.ERROR);
		}
	
	}
	private synchronized void loadView2(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			ListaControleDepartamentos controle = loader.getController();
			controle.setDepartmentServices(new DepartmentService());
			controle.updateTabelaView();
			
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro ao carregar a p�gina de visualiza��o", e.getMessage(), AlertType.ERROR);
		}
	
	}
}
