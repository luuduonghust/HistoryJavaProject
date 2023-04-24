//package com.example.services;
//
//import java.util.ArrayList;
//
//import entities.HistoricalSite;
//import utils.StringUtils;
//
//public class HistorySiteService implements HistoryMethod {
//
//	private ArrayList<HistoricalSite> hs;
//
//	public HistoricalSite searchByNameToInsert(ArrayList<HistoricalSite> hs, String name) {
//		for (HistoricalSite historicalSites : hs) {
//			if (historicalSites.getName().toLowerCase().indexOf(name.toLowerCase()) >= 0) {
//				return historicalSites;
//			}
//		}
//		return null;
//	}
//
//	public HistorySiteService(ArrayList<HistoricalSite> hs) {
//		this.hs = hs;
//	}
//
//	@Override
//	public ArrayList<?> show() {
//		return hs;
//	}
//
//	@Override
//	public ArrayList<?> searchByName(String name) {
//		ArrayList<HistoricalSite> filtered = new ArrayList<>();
//		if (name == null)
//			show();
//		for (HistoricalSite element : hs) {
//			if (StringUtils.isMatch(element.getName(), name) == true) {
//				filtered.add(element);
//			}
//		}
//		return filtered;
//	}
//
//	@Override
//	public Object searchID(int id) {
//		for (HistoricalSite element : hs) {
//			if (element.getId() == id) {
//				return element;
//			}
//		}
//
//		return null;
//	}
//
//}

package hust.hedspi.history_project.services;

import hust.hedspi.history_project.entities.Relic;
import hust.hedspi.history_project.utils.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RelicService implements HistoryMethod {

	private ObservableList<Relic> relics;

	public RelicService(ObservableList<Relic> relics) {
		this.relics = relics;
	}

	@Override
	public ObservableList<Relic> show() {
		return relics;
	}

	@Override
	public ObservableList<Relic> searchByName(String name) {
		ObservableList<Relic> filtered = FXCollections.observableArrayList();
		if (name == null)
			show();
		for (Relic element : relics) {
			if (StringUtils.isMatch(element.getName(), name)) {
				filtered.add(element);
			}
		}
		return filtered;
	}

	public Relic searchByNameToInsert(ObservableList<Relic> relicList, String value) {

		for (Relic relic : relicList) {
			if (relic.getName().toLowerCase().contains(value.toLowerCase())) {
				return relic;
			}
		}
		return null;
	}
}
