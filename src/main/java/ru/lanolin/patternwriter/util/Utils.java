package ru.lanolin.patternwriter.util;

import javafx.scene.control.TreeItem;
import ru.lanolin.patternwriter.domain.Pattern;

import java.util.List;

public final class Utils {

    public static Pattern example() {
        return new Pattern("main",
                List.of(
                        new Pattern("1",
                                List.of(new Pattern("2"),
                                        new Pattern("3", List.of(
                                                new Pattern("3"),
                                                new Pattern("4"),
                                                new Pattern("5")
                                        )),
                                        new Pattern("4")
                                )
                        ),
                        new Pattern("2"),
                        new Pattern("3")
                )
        );
    }

    public static TreeItem<String> convertPatternToTreeView(Pattern pattern) {
        if (pattern == null) {
            return null;
        }
        TreeItem<String> element = new TreeItem<>(pattern.getName());
        for (Pattern child : pattern.getChild()) {
            TreeItem<String> childItem = convertPatternToTreeView(child);
            if (childItem != null) element.getChildren().add(childItem);
        }
        return element;
    }

    public static Pattern convertTreeViewToPattern(TreeItem<String> items) {
        if (items == null) {
            return null;
        }
        Pattern pattern = new Pattern(items.getValue());
        for (TreeItem<String> item : items.getChildren()) {
            Pattern p = convertTreeViewToPattern(item);
            if (p != null) pattern.getChild().add(p);
        }
        return pattern;
    }

}
