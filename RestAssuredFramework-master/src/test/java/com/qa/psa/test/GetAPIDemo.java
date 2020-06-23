package com.qa.psa.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.psa.base.BaseTest;
import com.qa.psa.config.ReadConfig;
import com.qa.psa.utils.Utilities;
import com.qa.psa.verifications.Assertions;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPIDemo extends BaseTest {

    @BeforeTest
    public void startTest() {
        test.log(LogStatus.INFO, "Test Starting......");
    }

    @BeforeTest
    public void endTest() {
        test.log(LogStatus.INFO, "Test Ended......");
    }

    @Test(priority = 0)
    public void TC001() {

        // RestAssured.given().when().get(APIAddress.APIPath.GET_PDV).then().log().all();

        Response response = RestAssured.given().when().get(ReadConfig.propMain.getProperty("TC001_pdv"));

        System.out.println(Utilities.formatJSONResponse(response.getBody().asString()));

        logRequest(ReadConfig.propMain.getProperty("baseURI"), ReadConfig.propMain.getProperty("TC001_pdv"));
        logResponse(response);

        Assertions.verifyHTTPStatusCode(response, Integer.parseInt(ReadConfig.propMain.getProperty("TC001_status-code")));
        Assertions.verifyResponseTime(response);
        Assertions.verifyElementValue(response, ReadConfig.propMain.getProperty("TC001_key"));

    }

    @Test(priority = 1)
    public void TC002() {
        // RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS).then().log().all().statusCode(400);
        Response response = RestAssured.given().when().get(ReadConfig.propMain.getProperty("TC002_pdv"));

        System.out.println(Utilities.formatJSONResponse(response.getBody().asString()));

        logRequest(ReadConfig.propMain.getProperty("baseURI"), ReadConfig.propMain.getProperty("TC002_pdv"));
        logResponse(response);

        Assertions.verifyHTTPStatusCode(response, Integer.parseInt(ReadConfig.propMain.getProperty("TC002_status-code")));
        Assertions.verifyResponseTime(response);
        Assertions.verifyElementValue(response, ReadConfig.propMain.getProperty("TC002_key"));
    }

    @Test(priority = 2)
    public void TC003() {

        // RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS).then().log().all().statusCode(400);
        Response response = RestAssured.given().when().get(ReadConfig.propMain.getProperty("TC003_pdv"));

        System.out.println(Utilities.formatJSONResponse(response.getBody().asString()));

        logRequest(ReadConfig.propMain.getProperty("baseURI"), ReadConfig.propMain.getProperty("TC003_pdv"));
        logResponse(response);

        Assertions.verifyHTTPStatusCode(response, Integer.parseInt(ReadConfig.propMain.getProperty("TC003_status-code")));
        Assertions.verifyResponseTime(response);
        Assertions.verifyElementValue(response, ReadConfig.propMain.getProperty("TC003_key"));

    }

}
