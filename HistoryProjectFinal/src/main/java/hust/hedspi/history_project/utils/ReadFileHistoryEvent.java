package hust.hedspi.history_project.utils;

import java.io.FileReader;
import java.io.IOException;
//import java.util.Iterator;
//import java.util.Map;

import hust.hedspi.history_project.entities.HistoryEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFileHistoryEvent {
	private ObservableList<HistoryEvent> historyEventList;

	public ReadFileHistoryEvent() {
		this.historyEventList = FXCollections.observableArrayList();
	}

	public ObservableList<HistoryEvent> getHistoryEventList() throws IOException, ParseException {
		readFile();
		return historyEventList;
	}

	private void readFile() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("sukien3.json");
		Object obj = jsonParser.parse(reader);
		JSONArray culturList = (JSONArray) obj;
		for (Object object : culturList) {
			JSONObject jo = (JSONObject) object;
			HistoryEvent e1 = parse(jo);
			historyEventList.add(e1);
		}

	}

	private HistoryEvent parse(JSONObject jo) {
		String name = (String) jo.get("name");
		String date = (String) jo.get("date");
		String description = (String) jo.get("description");

		HistoryEvent e2 = new HistoryEvent(name, date, description);
		HistoryEvent e1 = (HistoryEvent) e2;
		return e1;

	}

}
