package alpha.vantage.utils;

import java.util.Properties;

import static java.lang.System.getProperty;

public class TestProperties {

    private static final String FILE_NAME = "config.properties";
    private static final String PROPERTY_URL = "base.url";
    private static final String API_KEY = "api.key";

    public static final String BASE_URL;
    public static final String DEFAULT_API_KEY_VALUE;

    static {
        Properties prop = new PropertiesLoader().load(FILE_NAME);
        BASE_URL = prop.getProperty(PROPERTY_URL, getProperty(PROPERTY_URL));
        DEFAULT_API_KEY_VALUE = prop.getProperty(API_KEY, getProperty(API_KEY));
    }
}
