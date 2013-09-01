package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.io.Assignment;
import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.mapping.NumberMapping;

import static com.tw.galaxyguide.io.Command.Type;
import static com.tw.galaxyguide.io.Command.Response;

public class NumeralMappingAssignmentHandler implements Handler {

    private Interpreter interpreter;
    private NumberMapping numberMapping;

    public NumeralMappingAssignmentHandler(Interpreter interpreter, NumberMapping numberMapping) {
        this.interpreter = interpreter;
        this.numberMapping = numberMapping;
    }

    @Override
    public Type getType() {
        return Type.Assignment.NUMERAL_MAPPING;
    }

    @Override
    public String process(String input) {
        Assignment assignment = interpreter.getAssignmentObjectFrom(input);
        String key = getAlienNumberFrom(assignment);
        String value = getRomanNumberFrom(assignment);
        numberMapping.add(key, value);
        return Response.SUCCESS;
    }

    private String getAlienNumberFrom(Assignment request) {
        return request.getLhs()[0];
    }

    private String getRomanNumberFrom(Assignment request) {
        return request.getRhs()[0];
    }

}
