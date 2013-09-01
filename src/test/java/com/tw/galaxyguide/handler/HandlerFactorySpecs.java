package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.handler.*;
import org.junit.Before;
import org.junit.Test;

import static com.tw.galaxyguide.io.Command.Type;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HandlerFactorySpecs {

    Handler mockCurrencyAssignmentHandler;
    Handler mockNumberAssignmentHandler;
    HandlerFactory handlerFactory;

    @Before
    public void setUp() throws Exception {
        mockCurrencyAssignmentHandler = mock(CreditValueAssignmentHandler.class);
        mockNumberAssignmentHandler = mock(NumeralMappingAssignmentHandler.class);
        handlerFactory = new HandlerFactory(mockCurrencyAssignmentHandler, mockNumberAssignmentHandler);
    }

    @Test
    public void itShouldReturnHandlerWithSameInputType() throws HandlerNotFoundException {
        //Given
        when(mockCurrencyAssignmentHandler.getType()).thenReturn(Type.Assignment.CREDIT_INFO);
        when(mockNumberAssignmentHandler.getType()).thenReturn(Type.Assignment.NUMERAL_MAPPING);
        //When
        Handler handler = handlerFactory.handlerFor(Type.Assignment.NUMERAL_MAPPING);
        //Then
        assertThat(handler, sameInstance(mockNumberAssignmentHandler));
    }
}
