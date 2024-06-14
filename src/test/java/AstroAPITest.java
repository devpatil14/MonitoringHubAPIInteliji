import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;

@Listeners({ExtentReportListener.class })  //Old.TestListener.class,ExtentReportListener.class
public class AstroAPITest extends BaseTest {

    @BeforeClass
    public void setup() {
        super.setup();
    }


    @Test(description = "Verify that the API returns status code 200 for getting Total CCTV API Count details",retryAnalyzer = RetryTestListener.class)
    public void testapicount() {
        ApiResponse response = apiClient.get(ApiConfig.getUsersEndpoint());
        //Assert.assertEquals(response.getStatusCode(), 200);
        try {
            assertEquals(response.getStatusCode(), 20);
            // Additional assertions for response body or headers can be added
            System.out.println("Test passed: Total CCTV Type API Count details retrieved successfully: " + response.getStatusCode());
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e;
        }
    }



}
