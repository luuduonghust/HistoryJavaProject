package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.Period;
import hust.hedspi.history_project.program.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PeriodController extends MenuOption {
	@FXML
	private TableView<Period> tblPeriod;

	@FXML
	private TableColumn<Period, String> colName;

	@FXML
	private TableColumn<Period, String> colDate;

	@FXML
	private TableColumn<Period, String> colDescription;

	@FXML
	private TextField searchField;


	private ObservableList<Period> listPeriod = FXCollections.observableArrayList();

	@FXML
	private void initialize() {

		listPeriod = Main.periodService.show();
		colName.setCellValueFactory(new PropertyValueFactory<Period, String>("name"));
		colDate.setCellValueFactory(new PropertyValueFactory<Period, String>("date"));
		colDescription.setCellValueFactory(new PropertyValueFactory<Period, String>("description"));
		searchField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				showFilterHistory(newValue);
			}
		});

		tblPeriod.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tblPeriod.setItems(listPeriod);
	}

	void showFilterHistory(String name) {
		tblPeriod.setItems(Main.periodService.searchByName(name));
	}

}
