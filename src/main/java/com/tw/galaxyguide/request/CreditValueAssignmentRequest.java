package com.tw.galaxyguide.request;

import java.util.Arrays;

import static com.tw.galaxyguide.io.Command.Type;

public class CreditValueAssignmentRequest implements Request {

    private String input;

    public CreditValueAssignmentRequest(String input) {
        this.input = input;
    }

    @Override
    public Type getType() {
        return Type.Assignment.CREDIT_INFO;
    }

    public String getElement() {
        String[] lValues = input.split("is")[0].split(" ");
        int lastElement = lValues.length - 1;
        return lValues[lastElement];
    }

    public String[] getAlienNumbers() {
        String[] lValues = input.split("is")[0].split(" ");
        int lastElementIndex = lValues.length - 1;
        return Arrays.copyOf(lValues, lastElementIndex);
    }

    public String getCreditAmount() {
        int first = 0;
        String[] rValues = input.split("is")[1].split(" ");
        return rValues[first];
    }
}

