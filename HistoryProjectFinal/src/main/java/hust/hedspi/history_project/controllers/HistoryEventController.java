package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.HistoryEvent;
import hust.hedspi.history_project.program.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoryEventController extends MenuOption {
	@FXML
	private TableView<HistoryEvent> tblEvent;

	@FXML
	private TableColumn<HistoryEvent, String> colName;

	@FXML
	private TableColumn<HistoryEvent, String> colDate;

	@FXML
	private TableColumn<HistoryEvent, String> colDescription;

	@FXML
	private TextField searchField;

	private ObservableList<HistoryEvent> listEvent = FXCollections.observableArrayList();

	@FXML
	private void initialize() {

		listEvent = Main.historyEventService.show();
		colName.setCellValueFactory(new PropertyValueFactory<HistoryEvent, String>("name"));
		colDate.setCellValueFactory(new PropertyValueFactory<HistoryEvent, String>("date"));
		colDescription.setCellValueFactory(new PropertyValueFactory<HistoryEvent, String>("description"));

		searchField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				showFilterHistory(newValue);
			}
		});
		tblEvent.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tblEvent.setItems(listEvent);
	}

	void showFilterHistory(String name) {
		tblEvent.setItems(Main.historyEventService.searchByName(name));
	}

}
