package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.handler.NumeralMappingAssignmentHandler;
import com.tw.galaxyguide.io.Assignment;
import com.tw.galaxyguide.io.Command;
import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.mapping.NumberMapping;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NumeralMappingHandlerSpecs {

    Interpreter mockInterpreter;
    NumberMapping numberMapping;
    NumeralMappingAssignmentHandler numeralMappingAssignmentHandler;

    @Before
    public void setUp() throws Exception {
        mockInterpreter = mock(Interpreter.class);
        numberMapping = mock(NumberMapping.class);
        numeralMappingAssignmentHandler = new NumeralMappingAssignmentHandler(mockInterpreter, numberMapping);
    }

    @Test
    public void itShouldAddAlienToRomanNumberMapping() {
        //Given
        String romanI = "I";
        String glob = "glob";
        String input = glob + " is " + romanI;
        Assignment mockAssignment = mock(Assignment.class);
            //Expectations
            when(mockInterpreter.getAssignmentObjectFrom(input)).thenReturn(mockAssignment);
            when(mockAssignment.getLhs()).thenReturn(new String[]{glob});
            when(mockAssignment.getRhs()).thenReturn(new String[]{romanI});

        //When
        String actualOutput = numeralMappingAssignmentHandler.process(input);

        //Then
        verify(numberMapping).add(glob, romanI);
        assertThat(actualOutput, is(Command.Response.SUCCESS));
    }
}
