package hust.hedspi.history_project.entities;

public class History {
	protected String name;
	protected String date;
	protected String description;

	public History(String name, String date, String description) {
		this.name = name;
		this.date = date;
		this.description = description;
	}

	public History(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

}
