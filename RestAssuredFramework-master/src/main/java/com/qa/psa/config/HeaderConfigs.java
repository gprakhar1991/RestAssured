package com.qa.psa.config;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

    public Map<String, String> getDefaultHeaders() {
        Map<String, String> headerMap = new HashMap<>();

        headerMap.put("Content-Type", "application/json");

        return headerMap;
    }

    public Map<String, String> getHeaderTokens() {
        Map<String, String> headerMap = new HashMap<>();

        headerMap.put("Access_Token", "sdjhvbshjdvbjhsdvbhjsdvbljhdsbv");

        return headerMap;
    }

}
