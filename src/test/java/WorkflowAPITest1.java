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

public class WorkflowAPITest1 {


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = BaseUrl.getBaseUrl();
        TestReporter.startReport();
    }


    @Test(description = "Verify that the API returns status code 200 for getting Workflow details")
    public void testgetworkflow() {
        Response response = given()
                .get(BaseUrl.getWorkFlowEndpoint());



        try {
            assertEquals(response.getStatusCode(), 200);
            // Additional assertions for response body or headers can be added
            System.out.println("Test passed: WorkFlow details retrieved successfully: " + response.getStatusCode());
            TestReporter.createTest("Get Workflow Test", "Verify that the API returns WorkFlow details");
            TestReporter.log(Status.PASS, "Test passed: WorkFlow details retrieved successfully");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            TestReporter.log(Status.FAIL, "Test Failed: WorkFlow details retrieved Fail");
            throw e;

        }
    }

    @AfterClass
    public void tearDown() {
        TestReporter.endTest();
    }
}
