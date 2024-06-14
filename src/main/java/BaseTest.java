import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

    public class BaseTest {

        public ApiClient apiClient;

        @BeforeClass
        public void setup() {
            apiClient = new ApiClient(ApiConfig.getBaseUrl());
        }

        @AfterClass
        public void teardown() {
            // Any cleanup can be done here
        }
}
