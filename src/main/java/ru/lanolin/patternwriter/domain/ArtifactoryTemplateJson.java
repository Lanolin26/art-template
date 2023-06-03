package ru.lanolin.patternwriter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ArtifactoryTemplateJson {
    private String name;

    private String excludeTemplate;
    private String includeTemplate;


    public ArtifactoryTemplate convert() {
        return new ArtifactoryTemplate();
    }

}
