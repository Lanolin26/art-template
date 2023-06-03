package ru.lanolin.patternwriter.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.lanolin.patternwriter.PatternWriterApplication;

public abstract class AbstractController {

    protected final PatternWriterApplication application;

    public AbstractController(PatternWriterApplication application) {
        this.application = application;
    }

}
