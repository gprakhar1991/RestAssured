package com.qa.psa.utils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class ExtentReportListner implements ITestListener {

    protected static ExtentReports reports;
    protected static ExtentTest test;

    private static String reportLocation = "test-output/Report/ExecutedOn_" + Utilities.getCurrentDate() + "_Time_" + Utilities.getCurrentTime()
            + "/";

    private static String resultpath = getResultPath();

    public static void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    System.out.println(files[i].getName());
                    if (files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    } else {
                        files[i].delete();
                    }
                }
            }
        }
    }

    private static String getResultPath() {

        resultpath = "test";

        if (!new File(resultpath).isDirectory()) {
            new File(resultpath);
        }
        return resultpath;
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = reports.startTest(result.getMethod().getMethodName());

        logTestMethodName(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(LogStatus.FAIL, "TEST FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, "TEST SKIPPED");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do Nothing
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Report Location ::" + reportLocation);

        reports = new ExtentReports(reportLocation + "ExtentReport.html");
        test = reports.startTest("");
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.endTest(test);
        reports.flush();
    }

    public void logTestMethodName(ITestResult result) {
        test.log(LogStatus.INFO, result.getMethod().getMethodName());
        System.out.println(result.getMethod().getMethodName());
        // System.out.println(result.getTestClass().getTestName());

    }

    public void logRequest(String baseURI, String index) {
        test.log(LogStatus.INFO, "Request URL:<br>" + baseURI + index);
    }

    public void logResponseHeader(Response response) {
        test.log(LogStatus.INFO, "Response Headers:<br>" + response.headers().toString());
    }

    public void logResponseBody(Response response) {
        test.log(LogStatus.INFO, "Response Body:<br>" + Utilities.formatJSONResponse(response.getBody().asString()));
    }

    public void logResponse(Response response) {
        logResponseHeader(response);
        logResponseBody(response);
    }

}
