package ru.lanolin.patternwriter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import ru.lanolin.patternwriter.CustomPair;
import ru.lanolin.patternwriter.PatternWriterApplication;

public class GeneralTab extends AbstractController {
    @FXML
    public TextField name;
    @FXML
    public Parent templateType;

    public GeneralTab(PatternWriterApplication application) {
        super(application);
    }

    @FXML
    public void action() {
        ChoiceBox<CustomPair<String, String>> type = (ChoiceBox<CustomPair<String, String>>) templateType;
        if (type.getSelectionModel().getSelectedItem() != null)
            System.out.println(type.getSelectionModel().getSelectedItem().key());
    }
}
