package com.tw.galaxyguide;

import static com.tw.galaxyguide.Command.Type;
import static com.tw.galaxyguide.Command.Response;

public class NumeralMappingHandler implements Handler {
    @Override
    public Type getType() {
        return Type.Assignment.NUMERAL_MAPPING;
    }

    @Override
    public String process(String input) {
        return Response.SUCCESS;
    }
}
