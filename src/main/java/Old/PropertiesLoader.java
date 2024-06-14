package Old;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

    public class PropertiesLoader {

        private static final String FILENAME = "endpoints.properties";
        private static final Properties properties = new Properties();

        static {
            try (InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(FILENAME)) {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getProperty(String key) {
            return properties.getProperty(key);
        }

}
