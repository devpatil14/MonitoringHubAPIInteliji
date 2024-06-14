package Old;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestReporter {

    public static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    public static ExtentTest test;


    public static void startReport() {
        // Generate folder names based on current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
        String currentDate = dateFormat.format(new Date());
        String currentTime = timeFormat.format(new Date());

        String reportPath = "test-output/" + currentDate + "/" + currentTime + "/";
        htmlReporter = new ExtentHtmlReporter(reportPath + "ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void createTest(String testName, String description) {
        test = extent.createTest(testName, description);
    }

    public static void log(Status status, String details) {
        if (test != null) {
            test.log(status, details);
        } else {
            System.out.println("Test not initialized.");
        }
    }

    public static void endTest() {
        if (extent != null) {
            extent.flush();
        } else {
            System.out.println("ExtentReports object is null. Cannot end report.");
        }
    }
}
