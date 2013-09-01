package com.tw.galaxyguide.request;

import static com.tw.galaxyguide.io.Command.Type;

public class NumeralMappingAssignmentRequest implements Request {

    private String input;

    public NumeralMappingAssignmentRequest(String input) {
        this.input = input;
    }

    @Override
    public Type getType() {
        return Type.Assignment.NUMERAL_MAPPING;
    }

    public String getAlienNumber() {
        return input.split("is")[0];
    }

    public String getRomanNumber() {
        return input.split("is")[1];
    }
}
