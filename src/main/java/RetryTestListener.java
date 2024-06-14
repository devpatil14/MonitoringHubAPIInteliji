import org.testng.IRetryAnalyzer;
import org.testng.*;
import com.aventstack.extentreports.Status;

    public class RetryTestListener implements IRetryAnalyzer {

        private int retryCount = 0;
        private static final int maxRetryCount = 2;

        @Override
        public boolean retry(ITestResult result) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                ExtentReportManager.getTest().log(Status.WARNING, "Retrying test " + result.getName() + " for the " + retryCount + " time.");
                return true; //retry test
            }
            return false; //dont retry test
        }
}
