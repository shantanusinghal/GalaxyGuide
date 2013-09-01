package com.tw.galaxyguide;

import com.tw.galaxyguide.handler.Handler;
import com.tw.galaxyguide.handler.HandlerFactory;
import com.tw.galaxyguide.exception.HandlerNotFoundException;
import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.request.Request;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static com.tw.galaxyguide.io.Command.Type;

public class TradingAssistantSpecs {

    Interpreter mockInterpreter;
    HandlerFactory mockHandlerFactory;
    TradingAssistant tradingAssistant;

    @Before
    public void setUp() {
        mockInterpreter = mock(Interpreter.class);
        mockHandlerFactory = mock(HandlerFactory.class);
        tradingAssistant = new TradingAssistant(mockInterpreter, mockHandlerFactory);
    }

    @Test
    public void itProcessAlienToRomanNumeralMapping() throws HandlerNotFoundException {
        //Given
        String input = "glob is I";
        String expectedOutput = "Cool! I learnt a new numeral";
        Handler mockHandler = mock(Handler.class);
        Request mockRequest = mock(Request.class);
        //Expectations
            when(mockInterpreter.getRequestObjectFrom(input)).thenReturn(mockRequest);
            when(mockRequest.getType()).thenReturn(Type.Assignment.NUMERAL_MAPPING);
            when(mockHandlerFactory.handlerFor(Type.Assignment.NUMERAL_MAPPING)).thenReturn(mockHandler);
            when(mockHandler.process(mockRequest)).thenReturn(expectedOutput);

        //when
        String actualOutput= tradingAssistant.process(input);

        //then
        assertThat(actualOutput, is(expectedOutput));
    }
}
