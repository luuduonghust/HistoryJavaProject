package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.Relic;
import hust.hedspi.history_project.program.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelicController extends MenuOption {
	@FXML
	private TableView<Relic> tblRelic;

	@FXML
	private TableColumn<Relic, String> colName;

	@FXML
	private TableColumn<Relic, String> colDescription;

	@FXML
	private TextField searchField;


	private ObservableList<Relic> listRelic = FXCollections.observableArrayList();

	@FXML
	public void initialize(ObservableList<Relic> dataInit) {

		listRelic = dataInit;
		colName.setCellValueFactory(new PropertyValueFactory<Relic, String>("name"));
		colDescription.setCellValueFactory(new PropertyValueFactory<Relic, String>("description"));
		searchField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				showFilterHistory(newValue);
			}
		});

		tblRelic.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tblRelic.setItems(listRelic);
	}

	void showFilterHistory(String name) {
		tblRelic.setItems(Main.relicService.searchByName(name));
	}

}
