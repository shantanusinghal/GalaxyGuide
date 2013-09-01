package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.io.Command;
import com.tw.galaxyguide.request.Request;
import static com.tw.galaxyguide.io.Command.Type;

public interface Handler {
    Type getType();
    <T extends Request> String process(T request);
}
