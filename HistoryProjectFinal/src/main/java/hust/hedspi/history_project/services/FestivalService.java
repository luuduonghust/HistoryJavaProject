package hust.hedspi.history_project.services;

import hust.hedspi.history_project.entities.Festival;
import hust.hedspi.history_project.utils.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FestivalService implements HistoryMethod {

	private ObservableList<Festival> festivalList;

	public FestivalService(ObservableList<Festival> festivalList) {
		this.festivalList = festivalList;
	}

	@Override
	public ObservableList<Festival> show() {
		return festivalList;
	}

	@Override
	public ObservableList<Festival> searchByName(String name) {
		ObservableList<Festival> filtered = FXCollections.observableArrayList();
		if (name == null)
			show();
		for (Festival element : festivalList) {
			if (StringUtils.isMatch(element.getName(), name)) {
				filtered.add(element);
			}
		}
		return filtered;
	}
}
