package com.tw.galaxyguide.handler;

import static com.tw.galaxyguide.io.Command.Type;

public interface Handler {
    Type getType();
    String process(String input);
}
