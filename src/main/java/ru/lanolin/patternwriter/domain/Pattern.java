package ru.lanolin.patternwriter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Pattern {
    private final String name;
    private List<Pattern> child = new ArrayList<>();
}
