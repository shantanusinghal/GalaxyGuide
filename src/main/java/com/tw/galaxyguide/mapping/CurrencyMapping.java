package com.tw.galaxyguide.mapping;

import java.util.HashMap;
import java.util.Map;

public class CurrencyMapping {

    private Map<String, Integer> currencyMapping;

    public CurrencyMapping(Map<String, Integer> currencyMapping) {
        this.currencyMapping = new HashMap<String, Integer>();
    }

    public void add(String key, String value) {
        currencyMapping.put(key, Integer.valueOf(value));
    }

    public Integer getValueOf(String alienNumber) {
        return currencyMapping.get(alienNumber);
    }

}
