package hust.hedspi.history_project.services;

import hust.hedspi.history_project.entities.Period;
import hust.hedspi.history_project.utils.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class PeriodService implements HistoryMethod {

	private ObservableList<Period> periods;

	public PeriodService(ObservableList<Period> periods) {
		this.periods = periods;
	}

	@Override
	public ObservableList<Period> show() {
		return periods;
	}

	@Override
	public ObservableList<Period> searchByName(String name) {
		ObservableList<Period> periodsFileted = FXCollections.observableArrayList();
		if (name == null)
			show();
		for (Period period : periods) {
			if (StringUtils.isMatch(period.getName(), name)) {
				periodsFileted.add(period);
			}
		}
		return periodsFileted;
	}

}
