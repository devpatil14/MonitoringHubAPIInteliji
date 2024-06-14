import Old.BaseUrl;
import Old.TestReporter;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserAPITest1 {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = BaseUrl.getBaseUrl();
        TestReporter.startReport();
    }


    @Test(description = "Verify that the API returns status code 200 for getting user details")
        public void testGetUser() {
            Response response = given()
                    .get(BaseUrl.getUserGetEndpoint());

            try {
                assertEquals(response.getStatusCode(), 200);
                // Additional assertions for response body or headers can be added
                System.out.println("Test passed: User details retrieved successfully: " + response.getStatusCode());
                TestReporter.createTest("Get User List", "Verify that the API returns user details");
                TestReporter.log(Status.PASS, "Test passed: User details retrieved successfully");
            } catch (AssertionError e) {
                TestReporter.log(Status.FAIL, "Test failed: User details retrieved Fail");
                System.out.println("Test failed: " + e.getMessage());
                throw e;
            }
        }

    @AfterClass
    public void tearDown() {
        TestReporter.endTest();
    }
}
