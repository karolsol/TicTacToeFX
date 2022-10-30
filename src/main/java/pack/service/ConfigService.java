package pack.service;

import java.io.*;
import java.util.Properties;

public class ConfigService {

    public String getTheme(){
        final Properties properties = new Properties();
        InputStream resourceAsStream;
        String theme;
        try {
            resourceAsStream = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            resourceAsStream = getClass().getResourceAsStream("/config.properties");
        }
        try {
            properties.load(resourceAsStream);
            theme = properties.getProperty("theme");
            assert resourceAsStream != null;
            resourceAsStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return theme;
    }
}
