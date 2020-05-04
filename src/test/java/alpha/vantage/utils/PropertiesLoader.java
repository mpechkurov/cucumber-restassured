package alpha.vantage.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public Properties load(String propertiesFileName) {
        try (final InputStream inputStream = PropertiesLoader.class.getClassLoader()
                                                                   .getResourceAsStream(propertiesFileName)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't find property file.", e);
        }
    }
}
