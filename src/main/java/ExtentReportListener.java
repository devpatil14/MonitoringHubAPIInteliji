import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

    public class ExtentReportListener implements ITestListener {

        @Override
        public void onStart(ITestContext context) {
            ExtentReportManager.getInstance();
        }

        @Override
        public void onFinish(ITestContext context) {
            ExtentReportManager.flush();
        }

        @Override
        public void onTestStart(ITestResult result) {
            ExtentReportManager.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            ExtentReportManager.getTest().log(Status.PASS, "Test passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            ExtentReportManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            ExtentReportManager.getTest().log(Status.SKIP, "Test skipped: " + result.getThrowable());
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
}
