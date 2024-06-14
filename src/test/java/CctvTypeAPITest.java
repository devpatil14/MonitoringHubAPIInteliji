import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CctvTypeAPITest extends BaseTest {
    @BeforeClass
    public void setup() {
        super.setup();
    }


    @Test(description = "Verify that the API returns status code 200 for getting Workflow details")
    public void testgetcctvtype() {
        ApiResponse response = apiClient.get(ApiConfig.getCctvtypeEndpoint());
        //Assert.assertEquals(response.getStatusCode(), 200);
        try {
            AssertJUnit.assertEquals(response.getStatusCode(), 200);
            // Additional assertions for response body or headers can be added
            System.out.println("Test passed: Total API Count details retrieved successfully: " + response.getStatusCode());
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e;
        }
    }
}
