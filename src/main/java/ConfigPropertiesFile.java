import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

    public class ConfigPropertiesFile {
        private static Properties properties;

        static {
            loadProperties();
        }

        private static void loadProperties() {
            properties = new Properties();
            try (InputStream input = new FileInputStream("src/main/resources/endpoints.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getProperty(String key) {
            return properties.getProperty(key);
        }
}
