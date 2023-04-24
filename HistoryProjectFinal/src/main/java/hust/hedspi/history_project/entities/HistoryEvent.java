package hust.hedspi.history_project.entities;

public class HistoryEvent extends History {
	private static int ID = 0;
	private int id;

	public HistoryEvent(String name, String date, String description) {
		super(name, date, description);
		this.id = ++ID;

	}

	public int getId() {
		return id;
	}

}
