package hust.hedspi.history_project.program;

import hust.hedspi.history_project.services.*;
import hust.hedspi.history_project.utils.*;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main extends Application {

	private static ReadFileFestival rff;
	private static ReadFilePerson rfp;
	private static ReadFileRelic rfr;
	private static ReadFilePeriod rfpr;
	private static ReadFileHistoryEvent rfhe;
	public static FestivalService festivalService;
	public static PersonService personService;
	public static RelicService relicService;
	public static PeriodService periodService;
	public static HistoryEventService historyEventService;


	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/hust/hedspi/history_project/historyinterface/Period.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		rff = new ReadFileFestival();
		festivalService = new FestivalService(rff.getFestivalList());
		rfp = new ReadFilePerson();
		personService = new PersonService(rfp.getPersonList());
		rfr = new ReadFileRelic();
		relicService = new RelicService(rfr.getRelicList());
		rfpr = new ReadFilePeriod();
		periodService = new PeriodService(rfpr.getPeriodList());
		rfhe = new ReadFileHistoryEvent();
		historyEventService = new HistoryEventService(rfhe.getHistoryEventList());
		launch();
	}
}