package ru.lanolin.patternwriter.util;

import javafx.scene.control.TreeItem;
import ru.lanolin.patternwriter.domain.Pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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


    public static Pattern patternFromFlatString(String flat) {
        String[] split = flat.split(",");
        Pattern root = new Pattern("");
        for (String item : split) {
            String[] tree = item.split("/");
            Pattern current = root;
            for (String name : tree) {
                Optional<Pattern> first = current.getChild().stream()
                        .filter(pattern -> pattern.getName().equalsIgnoreCase(name))
                        .findFirst();
                if (first.isPresent()) {
                    current = first.get();
                } else {
                    Pattern p = new Pattern(name);
                    current.getChild().add(p);
                    current = p;
                }
            }
        }
        return root;
    }

    public static String patternToFlatString(Pattern pattern) {
        List<String> strings = patternToFlatString("", pattern);
        return String.join(",", strings);
    }
    private static List<String> patternToFlatString(String prefix, Pattern pattern) {
        String pref1 = "";
        if(!prefix.isEmpty()) pref1 += prefix + "/";
        pref1 += pattern.getName();

        List<String> v = new ArrayList<>();
        if(pattern.getChild().size() == 0) v.add(pref1);
        for (Pattern pattern1 : pattern.getChild()) {
            List<String> strings = patternToFlatString(pref1, pattern1);
            v.addAll(strings);
        }
        return v;
    }

    public static void printlnPattern(Pattern out) {
        printlnPattern(0, out);
    }

    private static void printlnPattern(int level, Pattern out) {
        String step = String.join("", Collections.nCopies(level, " "));
        System.out.println(step + out.getName());
        for (Pattern pattern : out.getChild()) {
            printlnPattern(level + 1, pattern);
        }
    }
}
