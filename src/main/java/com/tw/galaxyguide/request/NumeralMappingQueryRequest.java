package com.tw.galaxyguide.request;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static com.tw.galaxyguide.io.Command.Type;

public class NumeralMappingQueryRequest implements Request{

    private String input;

    public NumeralMappingQueryRequest(String input) {
        this.input = input;
    }

    @Override
    public Type getType() {
        return Type.Query.HOW_MUCH;
    }

    public String[] getAlienNumbers() {
        String[] rValues = input.split("is")[1].split(" ");
        int lastElementIndex = rValues.length - 1;
        return Arrays.copyOf(rValues, lastElementIndex);
    }

    public String responseWith(String answer) {
        return StringUtils.join(getAlienNumbers(), ' ') + " is " + answer;
    }
}
