package com.tw.galaxyguide;

import com.tw.galaxyguide.handler.Handler;
import com.tw.galaxyguide.handler.HandlerException;
import com.tw.galaxyguide.handler.HandlerFactory;
import com.tw.galaxyguide.io.Interpreter;

import static com.tw.galaxyguide.io.Command.Type;
import static com.tw.galaxyguide.io.Command.Response;

public class TradingAssistant {

    private Interpreter interpreter;
    private HandlerFactory handlerFactory;

    public TradingAssistant(Interpreter interpreter, HandlerFactory handlerFactory) {
        this.interpreter = interpreter;
        this.handlerFactory = handlerFactory;
    }

    public String process(String input) {
        Type inputType = interpreter.getTypeOf(input);
        try {
            Handler handler = handlerFactory.handlerFor(inputType);
            return handler.process(input);
        }
        catch (HandlerException e) {
            return Response.ERROR;
        }
    }
}
