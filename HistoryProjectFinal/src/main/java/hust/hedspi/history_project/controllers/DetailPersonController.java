package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.Person;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class DetailPersonController extends MenuOption {
	@FXML
	private Label date;

	@FXML
	private Label description;

	@FXML
	private Label id;
	@FXML
	private Label born;
	@FXML
	private Label labelName;

	@FXML
	private Label name;
	@FXML
	private Label imageUrl;

	private Person selectedPerson;

	public void initData(Person person) {
		selectedPerson = person;
		id.setText(Integer.toString(selectedPerson.getId()));
		name.setText(selectedPerson.getName());
		born.setText(selectedPerson.getBorn());
		date.setText(selectedPerson.getDate());
		imageUrl.setText(selectedPerson.getImageUrl());
		description.setText(selectedPerson.getDescription());
		labelName.setText(selectedPerson.getName());
	}
}
