package com.qa.psa.config;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.qa.psa.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReadConfig extends BaseTest {

    public static Map<String, String> fileandenv = new HashMap<String, String>();
    public static Properties propMain = new Properties();
    public static Properties propPreSet = new Properties();

    public static Map<String, String> envAndFile() {

        try {
            test.log(LogStatus.INFO, "Loading Configuration file...");

            FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/inputs/config.properties");
            propMain.load(fisDev);

            fileandenv.put("baseURI", propMain.getProperty("baseURI"));

            test.log(LogStatus.INFO, "Configuration file loaded Successfully...");

        } catch (Exception e) {
            test.log(LogStatus.ERROR, "Error occured while loading Configuration Files" + e.fillInStackTrace());
        }

        // String environment = System.getProperty("env");

        /*
         * try { if (environment.equalsIgnoreCase("dev")) {
         * 
         * FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/inputs/dev.properties"); propMain.load(fisDev);
         * fileandenv.put("baseURI", propMain.getProperty("baseURI"));
         * 
         * } else if (environment.equalsIgnoreCase("qa")) { FileInputStream fisQA = new FileInputStream(System.getProperty("user.dir") +
         * "/inputs/qa.properties"); propMain.load(fisQA); fileandenv.put("baseURI", propMain.getProperty("baseURI"));
         * 
         * } else if (environment.equalsIgnoreCase("staging")) { FileInputStream fisStaging = new FileInputStream(System.getProperty("user.dir") +
         * "/inputs/staging.properties"); propMain.load(fisStaging); fileandenv.put("baseURI", propMain.getProperty("baseURI")); } } catch (Exception
         * e) { // TODO: handle exception }
         */

        return fileandenv;

    }

    public static Map<String, String> getConfigReader() {
        if (fileandenv == null) {
            fileandenv = envAndFile();
        }
        return fileandenv;
    }

}
