module HistoryProject {
	exports hust.hedspi.history_project.entities;
	exports hust.hedspi.history_project.utils;
	exports hust.hedspi.history_project.controllers;
	exports hust.hedspi.history_project.program;
	exports hust.hedspi.history_project.services;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires json.simple;
	opens hust.hedspi.history_project.controllers to javafx.fxml;
	opens hust.hedspi.history_project.entities to javafx.fxml;
}