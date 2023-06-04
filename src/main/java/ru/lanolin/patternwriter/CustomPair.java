package ru.lanolin.patternwriter;

import javafx.beans.NamedArg;

public record CustomPair<K, V>(@NamedArg("key") K key, @NamedArg("value") V value) {

    public static <A, B> CustomPair<A, B> of(A key, B value) {
        return new CustomPair<>(key, value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
