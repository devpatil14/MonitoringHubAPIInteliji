import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

    public class ExtentReportManager {

        private static ExtentReports extent;
        private static ExtentTest test;
        private static ExtentHtmlReporter htmlReporter;

        public static ExtentReports getInstance() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
           // SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
            String currentDate = dateFormat.format(new Date());
            //String currentTime = timeFormat.format(new Date());
            if (extent == null) {
                String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
                String reportName = System.getProperty("user.dir") + "/test-output/"+ currentDate +"/ExtentReport_" + timeStamp + ".html";
                htmlReporter = new ExtentHtmlReporter(reportName);
                htmlReporter.config().setTheme(Theme.STANDARD);
                htmlReporter.config().setDocumentTitle("API Test Report");
                htmlReporter.config().setReportName("API Test Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(htmlReporter);
            }
            return extent;
        }

        public static ExtentTest createTest(String testName, String description) {
            test = extent.createTest(testName, description);
            return test;
        }

        public static ExtentTest getTest() {
            return test;
        }

        public static void flush() {
            if (extent != null) {
                extent.flush();
            }
        }
}
