package com.tw.galaxyguide.mapping;

import com.tw.galaxyguide.roman.RomanNumber;

import java.util.HashMap;
import java.util.Map;

public class NumberMapping {

    private Map<String, RomanNumber> numberMapping;

    public NumberMapping(Map<String, RomanNumber> numberMapping) {
        this.numberMapping = new HashMap<String, RomanNumber>();
    }

    public void add(String key, String value) {
        numberMapping.put(key, RomanNumber.valueOf(value));
    }

    public RomanNumber getRomanOf(String alienNumber) {
        return null;
    }
}
