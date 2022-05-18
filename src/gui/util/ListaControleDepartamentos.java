package gui.util;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entidades.Departments;

public class ListaControleDepartamentos implements Initializable {

	@FXML
	private TableView<Departments> tabeladepartamentos;
	@FXML
	private TableColumn<Departments, Integer> tabelacolunaid;
	@FXML
	private TableColumn<Departments, String> tabelacolunanome;
	@FXML
	private Button btnew;
	@FXML
	public void onBtnewAcao() {
		System.out.println("onBtnewAcao");
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();	
	}

	private void initializeNodes() {
		tabelacolunaid.setCellValueFactory(new PropertyValueFactory<>("id"));
		tabelacolunanome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabeladepartamentos.prefHeightProperty().bind((ObservableValue<? extends Number>) Stage.getWindows());
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		
	}

}
