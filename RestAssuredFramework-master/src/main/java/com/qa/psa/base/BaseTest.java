package com.qa.psa.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.qa.psa.config.ReadConfig;
import com.qa.psa.utils.ExtentReportListner;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner {

    @BeforeClass
    public void initURL() {
        test.log(LogStatus.INFO, "Initializing Base URL...");
        RestAssured.baseURI = ReadConfig.envAndFile().get("baseURI");

        test.log(LogStatus.INFO, "Base URL initiated Successfully...");

    }

}
