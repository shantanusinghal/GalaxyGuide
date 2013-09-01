package com.tw.galaxyguide.io;

import com.tw.galaxyguide.request.Request;

public interface Interpreter {
    Request getRequestObjectFrom(String input);
}
