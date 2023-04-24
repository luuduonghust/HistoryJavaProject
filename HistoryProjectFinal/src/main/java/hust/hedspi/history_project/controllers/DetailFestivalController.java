package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.Festival;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailFestivalController extends MenuOption {
    @FXML
    private Label date;

    @FXML
    private Label description;

    @FXML
    private Label id;

    @FXML
    private Label labelName;

    @FXML
    private Label name;
    @FXML
    private Label address;

    private Festival selectedFestival;

    public void initData(Festival festival) {
        selectedFestival = festival;
        id.setText(Integer.toString(selectedFestival.getId()));
        name.setText(selectedFestival.getName());
        date.setText(selectedFestival.getDate());
        address.setText(selectedFestival.getAddress());
        description.setText(selectedFestival.getDescription());
        labelName.setText(selectedFestival.getName());
    }
}
