package com.tw.galaxyguide.handler;

import java.util.Arrays;
import java.util.List;

import static com.tw.galaxyguide.io.Command.Type;

public class HandlerFactory {

    private List<Handler> handlers;

    public HandlerFactory(Handler... handlers) {
        this.handlers = Arrays.asList(handlers);
    }

    public Handler handlerFor(Type inputType) throws HandlerNotFoundException {
        for (Handler handler : handlers) {
            if(handler.getType() == inputType)
                return handler;
        }
        throw new HandlerNotFoundException();
    }
}
