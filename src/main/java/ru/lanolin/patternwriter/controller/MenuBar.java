package ru.lanolin.patternwriter.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import ru.lanolin.patternwriter.PatternWriterApplication;

public class MenuBar extends AbstractController {

    public MenuBar(PatternWriterApplication application) {
        super(application);
    }

    @FXML
    public void importAction() {

    }

    @FXML
    public void exportAction() {

    }

    @FXML
    public void closeAction() {
        application.closeApplication();
    }

    @FXML
    public void aboutAction() {

    }

}
