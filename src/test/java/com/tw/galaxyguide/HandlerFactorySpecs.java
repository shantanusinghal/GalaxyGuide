package com.tw.galaxyguide;

import org.junit.Before;
import org.junit.Test;

import static com.tw.galaxyguide.Command.Type;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HandlerFactorySpecs {

    Handler mockCreditInfoHandler;
    Handler mockNumeralMappingHandler;
    HandlerFactory handlerFactory;

    @Before
    public void setUp() throws Exception {
        mockCreditInfoHandler = mock(CreditInfoHandler.class);
        mockNumeralMappingHandler = mock(NumeralMappingHandler.class);
        handlerFactory = new HandlerFactory(mockCreditInfoHandler, mockNumeralMappingHandler);
    }

    @Test
    public void itShouldReturnHandlerWithSameInputType() throws HandlerNotFoundException {
        //Given
        when(mockCreditInfoHandler.getType()).thenReturn(Type.Assignment.CREDIT_INFO);
        when(mockNumeralMappingHandler.getType()).thenReturn(Type.Assignment.NUMERAL_MAPPING);
        //When
        Handler handler = handlerFactory.handlerFor(Type.Assignment.NUMERAL_MAPPING);
        //Then
        assertThat(handler, instanceOf(NumeralMappingHandler.class));
    }
}
