package hust.hedspi.history_project.entities;

import javafx.collections.ObservableList;

public class Relic extends History {
	private static int ID = 0;
	private int id;

	private ObservableList<Person> relatePersons;

	public Relic(String name, String description, ObservableList<Person> relatePerson) {
		super(name, description);
		this.id = ++ID;
		this.relatePersons = relatePerson;
	}

	public int getId() {
		return id;
	}

	public ObservableList<Person> getRelatePersons() {
		return relatePersons;
	}

}
