package hust.hedspi.history_project.utils;

import java.io.FileReader;
import java.io.IOException;

import hust.hedspi.history_project.entities.Festival;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFileFestival {
	private ObservableList<Festival> festivalList;

	public ReadFileFestival() {
		this.festivalList = FXCollections.observableArrayList();
	}

	public ObservableList<Festival> getFestivalList() throws IOException, ParseException {
		readFile();
		return this.festivalList;
	}

	private void readFile() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("lehoi.json");
		Object obj = jsonParser.parse(reader);
		JSONArray fesList = (JSONArray) obj;
		for (Object object : fesList) {
			JSONObject jo = (JSONObject) object;
			Festival e1 = parse(jo);
			festivalList.add(e1);
		}
	}

	private Festival parse(JSONObject jo) {
		String name = (String) jo.get("ten");
		String date = (String) jo.get("ngayToChuc");
		String address = (String) jo.get("diaDiem");
		String description = (String) jo.get("moTa");
		Festival e2 = new Festival(name, date, address, description);
		Festival e1 = (Festival) e2;
		return e1;

	}
}
