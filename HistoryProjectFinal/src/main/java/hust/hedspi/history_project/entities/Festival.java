package hust.hedspi.history_project.entities;

public class Festival extends History {
	private static int ID = 0;
	private int id;
	private String address;

	public Festival(String name, String date, String address, String description) {
		super(name, date, description);
		this.id = ++ID;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

}
