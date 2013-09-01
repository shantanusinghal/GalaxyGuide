package com.tw.galaxyguide.io;

import static com.tw.galaxyguide.io.Command.Type;

public interface Interpreter {

    public Type getTypeOf(String input);

    Query getRequestObjectFrom(String input);

    Assignment getAssignmentObjectFrom(String input);
}
