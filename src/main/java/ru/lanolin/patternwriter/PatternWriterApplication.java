package ru.lanolin.patternwriter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class PatternWriterApplication extends Application {

    private Stage rootStage;

    @Override
    public void start(Stage stage) throws Exception {
        rootStage = stage;

        stage.setOnCloseRequest(t -> {
            // TODO: 03.06.2023 Save all and request to close
            Platform.exit();
            System.exit(0);
        });

        stage.setScene(loadScene("/ru/lanolin/patternwriter/mainScene.fxml"));
        stage.getIcons().add(loadImage("/icon.jpg"));
        stage.setHeight(1024d);
        stage.setWidth(1280d);
        stage.setTitle("Artifactory Pattern editor");
        stage.show();
    }

    public void closeApplication() {
        rootStage.close();
    }

    private Image loadImage(String name) throws FileNotFoundException {
        InputStream iconStream = getClass().getResourceAsStream(name);
        if (iconStream == null)
            throw new FileNotFoundException("File " + name + " not found.");
        return new Image(iconStream);
    }

    private Scene loadScene(String filename) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource(filename);
        loader.setControllerFactory(this::getControllerFactory);
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        return new Scene(root);
    }

    private Object getControllerFactory(Class<?> cClass) {
        try {
            Constructor<?> constructor = cClass.getConstructor(PatternWriterApplication.class);
            return constructor.newInstance(this);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            return null;
        }
    }

}
