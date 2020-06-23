package com.qa.psa.verifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.qa.psa.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class Assertions extends BaseTest {

    public static void verifyHTTPStatusCode(Response response, int statusCode) {

        try {
            Assert.assertEquals(statusCode, response.getStatusCode());
            test.log(LogStatus.PASS, "Successfully validated HTTPStatusCode, Current HTTPStatusCode is :: " + response.getStatusCode());

        } catch (

        AssertionError e) {
            test.log(LogStatus.ERROR, "Failed in verifyHTTPStatusCode" + e.fillInStackTrace());

            test.log(LogStatus.FAIL, "Expected HTTPStatusCode is :: " + statusCode + " , instead of :: " + response.getStatusCode());
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void verifyResponseKeyViaArray(Response response, String key) {
        try {
            JSONArray array = new JSONArray(response.getBody().asString());

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                test.log(LogStatus.PASS, "Validated values are  " + obj.get(key));
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void verifyElementValue(Response response, String key) {
        try {
            JSONObject json = new JSONObject(response.getBody().asString());

            if (json.has(key) && json.get(key) != null) {
                test.log(LogStatus.PASS, "Value of " + key + " is " + json.get(key));
            } else {
                test.log(LogStatus.FAIL, "Key is not available");
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

    public static void verifyResponseTime(Response response) {
        try {
            long time = response.time();

            test.log(LogStatus.INFO, "API response time is :: " + time);
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
        }
    }

}
