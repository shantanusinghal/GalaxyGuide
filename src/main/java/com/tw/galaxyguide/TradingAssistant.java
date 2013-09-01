package com.tw.galaxyguide;

import com.tw.galaxyguide.handler.Handler;
import com.tw.galaxyguide.exception.HandlerException;
import com.tw.galaxyguide.handler.HandlerFactory;
import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.request.Request;

import static com.tw.galaxyguide.io.Command.Response;

public class TradingAssistant {

    private Interpreter interpreter;
    private HandlerFactory handlerFactory;

    public TradingAssistant(Interpreter interpreter, HandlerFactory handlerFactory) {
        this.interpreter = interpreter;
        this.handlerFactory = handlerFactory;
    }

    public String process(String input) {
        try {
            Request request = interpreter.getRequestObjectFrom(input);
            Handler handler = handlerFactory.handlerFor(request.getType());
            return handler.process(request);
        }
        catch (HandlerException e) {
            return Response.ERROR;
        }
    }
}
