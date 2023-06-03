module ru.lanolin.patternwriter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens ru.lanolin.patternwriter to javafx.fxml;
    exports ru.lanolin.patternwriter;
}