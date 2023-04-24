package hust.hedspi.history_project.services;

import javafx.collections.ObservableList;


public interface HistoryMethod {
	ObservableList<?> show();

	ObservableList<?> searchByName(String name);
}
