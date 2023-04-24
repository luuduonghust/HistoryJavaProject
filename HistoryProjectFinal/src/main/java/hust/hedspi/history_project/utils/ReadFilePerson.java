package hust.hedspi.history_project.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import hust.hedspi.history_project.entities.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFilePerson {
	private ObservableList<Person> personList;

	public ObservableList<Person> getPersonList() throws IOException, ParseException {
		readFile();
		return personList;
	}

//	public ReadFilePerson(ObservableList<Person> personList) {
//		this.personList = personList;
//	}

	public ReadFilePerson() {
		this.personList = FXCollections.observableArrayList();
	}

	private void readFile() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("nhanvat.json");
		Object obj = jsonParser.parse(reader);
		JSONArray personlist = (JSONArray) obj;
		for (Object object : personlist) {
			JSONObject jo = (JSONObject) object;
			Person e1 = parse(jo);
			personList.add(e1);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Person parse(JSONObject obj) throws IOException, ParseException {

		ArrayList<String> listRelics = new ArrayList<String>();
		JSONObject jr = (JSONObject) obj.get("Relate");
		Map site = ((Map) jr.get("Dia danh"));
		Iterator<Map.Entry> itr2 = site.entrySet().iterator();
		while (itr2.hasNext()) {
			Map.Entry pair = itr2.next();
			listRelics.add((String) pair.getValue());
		}

		String name = (String) obj.get("Ten");
		String date = (String) obj.get("Mat");
		String description = (String) obj.get("Mo ta");
		String imageUrl = (String) obj.get("Img");
		String born = (String) obj.get("Sinh");

		Person e1 = new Person(name, date, description, imageUrl, born, listRelics);
		return e1;

	}
}
