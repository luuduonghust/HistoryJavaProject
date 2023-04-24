package hust.hedspi.history_project.entities;

import javafx.collections.ObservableList;

public class Period extends History {
	private static int ID = 0;
	private int id;
	private ObservableList<Person> personList;
	private ObservableList<Relic> relicList;

	public Period(String name, String date, String description, ObservableList<Person> personList,
			ObservableList<Relic> relicList) {
		super(name, date, description);
		this.id = ++ID;
		this.personList = personList;
		this.relicList = relicList;

	}

	public int getId() {
		return id;
	}

	public ObservableList<Person> getPersonList() {
		return personList;
	}

	public ObservableList<Relic> getRelicList() {
		return relicList;
	}

}
