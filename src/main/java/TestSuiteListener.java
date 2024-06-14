import org.testng.ISuite;
import org.testng.ISuiteListener;

    public class TestSuiteListener implements ISuiteListener {

        @Override
        public void onStart(ISuite suite) {
            // Initialize Extent Reports before the suite starts
            ExtentReportManager.getInstance();
        }

        @Override
        public void onFinish(ISuite suite) {
            // Flush the Extent Reports after the suite finishes
            ExtentReportManager.flush();
        }
}
