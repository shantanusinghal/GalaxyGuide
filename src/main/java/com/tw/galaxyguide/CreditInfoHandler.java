package com.tw.galaxyguide;

import static com.tw.galaxyguide.Command.Type;
import static com.tw.galaxyguide.Command.Response;

public class CreditInfoHandler implements Handler {
    @Override
    public Type getType() {
        return Type.Assignment.CREDIT_INFO;
    }

    @Override
    public String process(String input) {
        return Response.SUCCESS;
    }
}
