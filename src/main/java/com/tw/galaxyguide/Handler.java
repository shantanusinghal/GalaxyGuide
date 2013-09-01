package com.tw.galaxyguide;

import static com.tw.galaxyguide.Command.Type;

public interface Handler {
    Type getType();
    String process(String input);
}
