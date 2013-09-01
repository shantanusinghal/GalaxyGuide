package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.request.NumeralMappingAssignmentRequest;
import com.tw.galaxyguide.request.Request;
import com.tw.galaxyguide.mapping.NumberMapping;

import static com.tw.galaxyguide.io.Command.Type;
import static com.tw.galaxyguide.io.Command.Response;

public class NumeralMappingAssignmentHandler implements Handler {

    private NumberMapping numberMapping;

    public NumeralMappingAssignmentHandler(NumberMapping numberMapping) {
        this.numberMapping = numberMapping;
    }

    @Override
    public Type getType() {
        return Type.Assignment.NUMERAL_MAPPING;
    }

    @Override
    public <T extends Request> String process(T requestObj) {
        NumeralMappingAssignmentRequest request = (NumeralMappingAssignmentRequest) requestObj;
        String key = request.getAlienNumber();
        String value = request.getRomanNumber();
        numberMapping.add(key, value);
        return Response.SUCCESS;
    }
}
