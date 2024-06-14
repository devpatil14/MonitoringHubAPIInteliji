package Old;

import groovyjarjarantlr4.v4.runtime.RuleDependency;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseUrl {


    public static String getBaseUrl() {
        return PropertiesLoader.getProperty("BASE_URI");
    }

    public static String getUserGetEndpoint() {
        return PropertiesLoader.getProperty("USER_GET_ENDPOINT");
    }

    /*    public static String getUserCreateEndpoint() {
            return Old.PropertiesLoader.getProperty("USER_CREATE_ENDPOINT");
        }

        public static String getUserUpdateEndpoint() {
            return Old.PropertiesLoader.getProperty("USER_UPDATE_ENDPOINT");
        }

        public static String getUserDeleteEndpoint() {
            return Old.PropertiesLoader.getProperty("USER_DELETE_ENDPOINT");
        }*/
    public static String getWorkFlowEndpoint() {
        return PropertiesLoader.getProperty("WORKFLOW_GET_ENDPOINT");
    }

    public static String getTotalAPICountEndpoint() {
        return PropertiesLoader.getProperty("TotalApiCount_GET_ENDPOINT");
    }

    public static String getCctvTypeEndpoint() {
        return PropertiesLoader.getProperty("CCTVType_GET_ENDPOINT");
    }

}
