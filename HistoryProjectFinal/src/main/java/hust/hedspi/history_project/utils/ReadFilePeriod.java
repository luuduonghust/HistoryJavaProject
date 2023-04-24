package hust.hedspi.history_project.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import hust.hedspi.history_project.entities.History;
import hust.hedspi.history_project.entities.Period;
import hust.hedspi.history_project.entities.Person;
import hust.hedspi.history_project.entities.Relic;
import hust.hedspi.history_project.services.PersonService;
import hust.hedspi.history_project.services.RelicService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFilePeriod {
	private ObservableList<Period> periodLists;

	public ReadFilePeriod() {
		this.periodLists = FXCollections.observableArrayList();
	}

	public ObservableList<Period> getPeriodList() {
		readFile();
		return periodLists;
	}

	private void readFile() {
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("thoiki1.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);
			ReadFilePerson rfp = new ReadFilePerson();
			PersonService lp = new PersonService(rfp.getPersonList());

			ReadFileRelic rfr = new ReadFileRelic();
			RelicService ls = new RelicService(rfr.getRelicList());
			JSONArray listPeriods = (JSONArray) obj;
			for (Object object : listPeriods) {

				JSONObject jo = (JSONObject) object;
				Period e1 = parse(jo, lp, ls);
				periodLists.add(e1);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	private Period parse(JSONObject jo, PersonService lp, RelicService ls) throws IOException, ParseException {

		ObservableList<Person> personList = FXCollections.observableArrayList();
		ObservableList<Relic> relics = FXCollections.observableArrayList();

		String name = (String) jo.get("date");
		String date = (String) jo.get("Thoi Ki");
		String description = (String) jo.get("description");
		JSONObject jr = (JSONObject) jo.get("Relate");

		Map person = ((Map) jr.get("Nhan vat"));
		@SuppressWarnings("unchecked")
		Iterator<Map.Entry> itr1 = person.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry pair = itr1.next();
			Person e = lp.searchByNameToInsert(lp.show(), (String) pair.getValue());
			personList.add(e);

		}

		Map site = ((Map) jr.get("Dia danh"));
		@SuppressWarnings("unchecked")
		Iterator<Map.Entry> itr2 = site.entrySet().iterator();
		while (itr2.hasNext()) {
			Map.Entry pair = itr2.next();
			Relic a = (Relic) ls.searchByNameToInsert(ls.show(), (String) pair.getValue());
			relics.add(a);

		}

		History e2 = new Period(name, date, description, personList, relics);
		Period e1 = (Period) e2;

		return e1;
	}
}
