package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.io.Command;
import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.mapping.NumberMapping;
import com.tw.galaxyguide.request.NumeralMappingAssignmentRequest;
import com.tw.galaxyguide.request.Request;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NumeralMappingAssignmentHandlerSpecs {

    NumberMapping numberMapping;
    NumeralMappingAssignmentHandler numeralMappingAssignmentHandler;

    @Before
    public void setUp() throws Exception {
        numberMapping = mock(NumberMapping.class);
        numeralMappingAssignmentHandler = new NumeralMappingAssignmentHandler(numberMapping);
    }

    @Test
    public void itShouldAddAlienToRomanNumberMapping() {
        //Given
        String romanI = "I";
        String glob = "glob";
        NumeralMappingAssignmentRequest mockRequest = mock(NumeralMappingAssignmentRequest.class);
            //Expectations
            when(mockRequest.getAlienNumber()).thenReturn(glob);
            when(mockRequest.getRomanNumber()).thenReturn(romanI);

        //When
        String actualOutput = numeralMappingAssignmentHandler.process(mockRequest);

        //Then
        verify(numberMapping).add(glob, romanI);
        assertThat(actualOutput, is(Command.Response.SUCCESS));
    }
}
