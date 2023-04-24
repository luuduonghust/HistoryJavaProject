package hust.hedspi.history_project.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import hust.hedspi.history_project.entities.Relic;
import hust.hedspi.history_project.services.PersonService;

import hust.hedspi.history_project.entities.Person;

public class ReadFileRelic {
	private ObservableList<Relic> relicList;

	public ReadFileRelic() {
		this.relicList = FXCollections.observableArrayList();
	}

	public ObservableList<Relic> getRelicList() throws IOException, ParseException {
		readFile();
		return this.relicList;
	}

	private void readFile() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("diadanh1.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			ReadFilePerson rfp = new ReadFilePerson();

			PersonService personService = new PersonService(rfp.getPersonList());

			JSONArray relicsList = (JSONArray) obj;
			for (Object object : relicsList) {
				JSONObject jo = (JSONObject) object;
				Relic e1 = parse(jo, personService);
				relicList.add(e1);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private Relic parse(JSONObject jo, PersonService personService) throws IOException, ParseException {

		ObservableList<Person> relatePersons = FXCollections.observableArrayList();

		String name = (String) jo.get("name");
		String description = (String) jo.get("description");

		for (Person person : personService.show()) {
			if (person.getRelicList().contains(name))
				relatePersons.add(person);
		}

		Relic e2 = new Relic(name, description, relatePersons);
		Relic e1 = (Relic) e2;
		return e1;
	}
}
