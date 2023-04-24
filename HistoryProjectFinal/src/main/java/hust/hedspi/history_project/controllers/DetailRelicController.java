package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.Relic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailRelicController extends MenuOption {

	@FXML
	private Label description;

	@FXML
	private Label id;

	@FXML
	private Label labelName;

	@FXML
	private Label name;

	private Relic selectedRelic;

	@FXML
	private Button redirectPersonBtn;

	public void initData(Relic relic) {
		selectedRelic = relic;
		id.setText(Integer.toString(selectedRelic.getId()));
		name.setText(selectedRelic.getName());
		description.setText(selectedRelic.getDescription());
		labelName.setText(selectedRelic.getName());
		if(selectedRelic.getRelatePersons().isEmpty()) {
			redirectPersonBtn.setVisible(false);
		}
	}

	@SuppressWarnings("exports")
	public void redirect(ActionEvent event) throws IOException {
		if (event.getSource() == redirectPersonBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/Person.fxml"));
			root = loader.load();
			PersonController controller = loader.getController();
			controller.initialize(selectedRelic.getRelatePersons());	
		}
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
