package com.tw.galaxyguide;

import static com.tw.galaxyguide.Command.Type;

public interface Interpreter {
    public Type getTypeOf(String input);
}
