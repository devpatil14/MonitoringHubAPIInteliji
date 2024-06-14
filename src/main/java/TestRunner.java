import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import java.util.ArrayList;
import java.util.List;

    public class TestRunner {

        public static void main(String[] args) {
            TestNG testNG = new TestNG();
            List<String> suites = new ArrayList<>();
            suites.add("./testng.xml"); // path to your testng.xml file
            testNG.setTestSuites(suites);
            testNG.run();
        }


}
