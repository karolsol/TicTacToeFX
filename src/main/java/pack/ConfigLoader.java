package pack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    public String getTheme() {
        String theme = "";
        try {
            final Properties properties = new Properties();
            InputStream resourceAsStream = getClass().getResourceAsStream("/config.properties");
            if (resourceAsStream == null) {
                throw new FileNotFoundException("config.properties does not exist");
            }
            properties.load(resourceAsStream);
            theme = properties.getProperty("theme");
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theme;
    }

}
