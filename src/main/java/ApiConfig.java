
public class ApiConfig {

        public static String getBaseUrl() {
            return ConfigPropertiesFile.getProperty("BASE_URI");
        }

        public static String getUsersEndpoint() {
            return ConfigPropertiesFile.getProperty("TotalApiCount_GET_ENDPOINT");
        }

        public static String getCctvtypeEndpoint() {
             return ConfigPropertiesFile.getProperty("CCTVType_GET_ENDPOINT");
         }

        // Add more methods to access additional endpoints if needed
}
