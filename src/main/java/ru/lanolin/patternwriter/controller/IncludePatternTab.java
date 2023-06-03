package ru.lanolin.patternwriter.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ru.lanolin.patternwriter.PatternWriterApplication;
import ru.lanolin.patternwriter.domain.Pattern;
import ru.lanolin.patternwriter.util.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class IncludePatternTab extends AbstractController implements Initializable {

    @FXML
    private TreeView<String> tree;

    public IncludePatternTab(PatternWriterApplication application) {
        super(application);
    }

    private TreeItem<String> treeStruct() {

        return null;
    }

    @FXML
    public void loadAction() {
        tree.setRoot(Utils.convertPatternToTreeView(Utils.example()));
//        System.out.println(tree.get);
    }

    @FXML
    public void sout() {
        Pattern pattern = Utils.convertTreeViewToPattern(tree.getRoot());
        System.out.println(pattern);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree.setEditable(true);
        tree.setCellFactory(p -> new TextFieldTreeCellImpl());
    }

}
