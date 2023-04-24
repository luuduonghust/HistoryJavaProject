package hust.hedspi.history_project.entities;

import java.util.ArrayList;

public class Person extends History {

	private static int ID = 0;
	private int id;
	private String imageUrl;
	private String born;
	private ArrayList<String> relicList;

	public Person(String name, String date, String description, String imageUrl, String born,
			ArrayList<String> relicList) {
		super(name, date, description);
		this.id = ++ID;
		this.born = born;
		this.imageUrl = imageUrl;
		this.relicList = relicList;
	}

	public int getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getBorn() {
		return born;
	}

	public ArrayList<String> getRelicList() {
		return relicList;
	}

}
