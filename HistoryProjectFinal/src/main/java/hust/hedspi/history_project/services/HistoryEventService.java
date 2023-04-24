package hust.hedspi.history_project.services;

import hust.hedspi.history_project.entities.HistoryEvent;

import hust.hedspi.history_project.utils.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HistoryEventService implements HistoryMethod {

	private ObservableList<HistoryEvent> historyEventList;

	public HistoryEventService(ObservableList<HistoryEvent> historyEventList) {
		this.historyEventList = historyEventList;
	}

	@Override
	public ObservableList<HistoryEvent> show() {
		return historyEventList;
	}

	@Override
	public ObservableList<HistoryEvent> searchByName(String name) {
		ObservableList<HistoryEvent> historyEventFileted = FXCollections.observableArrayList();
		if (name == null)
			show();
		for (HistoryEvent historyEvent : historyEventList) {
			if (StringUtils.isMatch(historyEvent.getName(), name)) {
				historyEventFileted.add(historyEvent);
			}
		}
		return historyEventFileted;
	}

}
