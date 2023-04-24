package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.Person;
import hust.hedspi.history_project.program.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonController extends MenuOption {
	@FXML
	private TableView<Person> tblPerson;

	@FXML
	private TableColumn<Person, String> colName;
	@FXML
	private TableColumn<Person, String> colBorn;
	@FXML
	private TableColumn<Person, String> colDate;

	@FXML
	private TableColumn<Person, String> colDescription;

	@FXML
	private TextField searchField;

	private ObservableList<Person> listPerson = FXCollections.observableArrayList();

	@FXML
	public void initialize(ObservableList<Person> dataInit) {
		listPerson = dataInit;
		colName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
		colBorn.setCellValueFactory(new PropertyValueFactory<Person, String>("born"));
		colDate.setCellValueFactory(new PropertyValueFactory<Person, String>("date"));
		colDescription.setCellValueFactory(new PropertyValueFactory<Person, String>("description"));
		searchField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				showFilterHistory(newValue);
			}
		});

		tblPerson.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tblPerson.setItems(listPerson);
	}

	void showFilterHistory(String name) {
		tblPerson.setItems(Main.personService.searchByName(name));
	}

}
