package hust.hedspi.history_project.controllers;

import hust.hedspi.history_project.entities.*;
import hust.hedspi.history_project.program.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuOption {
	protected Stage stage;
	protected Scene scene;
	protected Parent root;

	@FXML
	private Button periodBtn;

	@FXML
	private Button eventBtn;

	@FXML
	private Button personBtn;

	@FXML
	private Button festivalBtn;

	@FXML
	private Button relicBtn;

	@FXML
	private TextField searchField;

	@FXML
	private Button detailPeriodBtn;

	@FXML
	private Button detailEventBtn;

	@FXML
	private Button detailPersonBtn;

	@FXML
	private Button detailFestivalBtn;

	@FXML
	private Button detailRelicBtn;

	@FXML
	private TableView<Period> tblPeriod;

	@FXML
	private TableView<HistoryEvent> tblEvent;

	@FXML
	private TableView<Person> tblPerson;

	@FXML
	private TableView<Festival> tblFestival;

	@FXML
	private TableView<Relic> tblRelic;

	@SuppressWarnings("exports")
	public void onButtonPressed(ActionEvent event) throws IOException {
		if (event.getSource() == periodBtn) {
			root = FXMLLoader.load(getClass().getResource("/hust/hedspi/history_project/historyinterface/Period.fxml"));
		} else if (event.getSource() == eventBtn) {
			root = FXMLLoader.load(getClass().getResource("/hust/hedspi/history_project/historyinterface/Event.fxml"));
		} else if (event.getSource() == personBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/Person.fxml"));
			root = loader.load();
			PersonController controller = loader.getController();
			controller.initialize(Main.personService.show());
		} else if (event.getSource() == festivalBtn) {
			root = FXMLLoader.load(getClass().getResource("/hust/hedspi/history_project/historyinterface/Festival.fxml"));
		} else if (event.getSource() == relicBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/Relic.fxml"));
			root = loader.load();
			RelicController controller = loader.getController();
			controller.initialize(Main.relicService.show());
		} else if (event.getSource() == detailPeriodBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/DetailPeriod.fxml"));
			root = loader.load();
			DetailPeriodController controller = loader.getController();
			controller.initData(tblPeriod.getSelectionModel().getSelectedItem());
		} else if (event.getSource() == detailEventBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/DetailEvent.fxml"));
			root = loader.load();
			DetailHistoryEventController controller = loader.getController();
			controller.initData(tblEvent.getSelectionModel().getSelectedItem());
		} else if (event.getSource() == detailPersonBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/DetailPerson.fxml"));
			root = loader.load();
			DetailPersonController controller = loader.getController();
			controller.initData(tblPerson.getSelectionModel().getSelectedItem());
		} else if (event.getSource() == detailFestivalBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/DetailFestival.fxml"));
			root = loader.load();
			DetailFestivalController controller = loader.getController();
			controller.initData(tblFestival.getSelectionModel().getSelectedItem());
		} else if (event.getSource() == detailRelicBtn) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/hust/hedspi/history_project/historyinterface/DetailRelic.fxml"));
			root = loader.load();
			DetailRelicController controller = loader.getController();
			controller.initData(tblRelic.getSelectionModel().getSelectedItem());
		}

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
