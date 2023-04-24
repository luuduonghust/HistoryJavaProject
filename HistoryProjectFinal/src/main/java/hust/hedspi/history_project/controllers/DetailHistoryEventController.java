package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.HistoryEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailHistoryEventController extends MenuOption {
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

    private HistoryEvent selectedEvent;

    public void initData(HistoryEvent event) {
        selectedEvent = event;
        id.setText(Integer.toString(selectedEvent.getId()));
        name.setText(selectedEvent.getName());
        date.setText(selectedEvent.getDate());
        description.setText(selectedEvent.getDescription());
        labelName.setText(selectedEvent.getName());
    }
}
