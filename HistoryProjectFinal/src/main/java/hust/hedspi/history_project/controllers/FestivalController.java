package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.Festival;
import hust.hedspi.history_project.program.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class FestivalController extends MenuOption {
	@FXML
	private TableView<Festival> tblFestival;

	@FXML
	private TableColumn<Festival, String> colName;

	@FXML
	private TableColumn<Festival, String> colDate;
	@FXML
	private TableColumn<Festival, String> colAddress;
	@FXML
	private TableColumn<Festival, String> colDescription;

	@FXML
	private TextField searchField;

	@FXML
	private Button detailFestivalBtn;

	private ObservableList<Festival> listFestival = FXCollections.observableArrayList();

	@FXML
	private void initialize() {

		listFestival = Main.festivalService.show();
		colName.setCellValueFactory(new PropertyValueFactory<Festival, String>("name"));
		colDate.setCellValueFactory(new PropertyValueFactory<Festival, String>("date"));
		colAddress.setCellValueFactory(new PropertyValueFactory<Festival, String>("address"));
		colDescription.setCellValueFactory(new PropertyValueFactory<Festival, String>("description"));
		searchField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				showFilterHistory(newValue);
			}
		});

		tblFestival.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tblFestival.setItems(listFestival);
	}

	void showFilterHistory(String name) {
		tblFestival.setItems(Main.festivalService.searchByName(name));
	}

}
