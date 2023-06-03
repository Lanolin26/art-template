package ru.lanolin.patternwriter;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.Optional;

public final class Props {

    private final static Props instance;

    public static Props getInstance() {
        return instance;
    }

    static {
        try {
            instance = new Props();
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String DEFAULT_TITLE = "Default Title";
    private static final String KEY_TITLE = "title";

    private final Configuration config;

    private Props() throws ConfigurationException {
        Configurations configs = new Configurations();

        config = configs.properties(new File("application.properties"));
    }


    public Optional<Object> getObject(String key) {
        return Optional.ofNullable(config.getProperty(key));
    }

    public String getMainTitle() {
        return config.getString(KEY_TITLE, DEFAULT_TITLE);
    }

}
