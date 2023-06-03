package ru.lanolin.patternwriter.controller;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

class TextFieldTreeCellImpl extends TreeCell<String> {
    private TextField textField;
    private ContextMenu addMenu = new ContextMenu();

    public TextFieldTreeCellImpl() {
        MenuItem addMenuItem = new MenuItem("Add element");
        addMenu.getItems().add(addMenuItem);
        addMenuItem.setOnAction(t -> getTreeItem().getChildren().add(new TreeItem<>("new item")));
        MenuItem removeItem = new MenuItem("Remove element");
        addMenu.getItems().add(removeItem);
        removeItem.setOnAction(t -> {
            TreeItem<String> item = getTreeView().getSelectionModel().getSelectedItem();
            item.getParent().getChildren().remove(item);
        });
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }
        setText(null);
        setGraphic(textField);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem());
        setGraphic(getTreeItem().getGraphic());
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setContextMenu(addMenu);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(getTreeItem().getGraphic());
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
            if (newPropertyValue) {
                System.out.println("Textfield on focus");
            } else {
                System.out.println("Textfield out focus");
            }
        });
        textField.setOnKeyReleased(t -> {
            if (t.getCode() == KeyCode.ENTER) {
                commitEdit(textField.getText());
            } else if (t.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem();
    }
}
