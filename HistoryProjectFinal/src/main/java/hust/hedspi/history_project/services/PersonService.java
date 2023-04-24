package hust.hedspi.history_project.services;

import hust.hedspi.history_project.entities.Person;
import hust.hedspi.history_project.utils.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonService implements HistoryMethod {

	private ObservableList<Person> persons;

	public PersonService(ObservableList<Person> persons) {
		this.persons = persons;
	}

	public Person searchByNameToInsert(ObservableList<Person> pers, String name) {
		for (Person person : pers) {
			if (person.getName().toLowerCase().contains(name.toLowerCase())) {
				return person;
			}
		}
		return null;
	}

	@Override
	public ObservableList<Person> show() {
		return persons;
	}

	@Override
	public ObservableList<Person> searchByName(String name) {
		ObservableList<Person> filtered = FXCollections.observableArrayList();
		if (name == null)
			show();
		for (Person element : persons) {
			if (StringUtils.isMatch(element.getName(), name)) {
				filtered.add(element);
			}
		}
		return filtered;
	}
}
