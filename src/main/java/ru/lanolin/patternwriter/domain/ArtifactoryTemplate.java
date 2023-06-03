package ru.lanolin.patternwriter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ArtifactoryTemplate {
    private String name;

    private Pattern excludeTemplate;
    private Pattern includeTemplate;


}
