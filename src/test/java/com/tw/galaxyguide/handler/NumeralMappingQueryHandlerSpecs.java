package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.handler.NumeralMappingQueryHandler;
import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.io.Query;
import com.tw.galaxyguide.mapping.NumberMapping;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumeralMappingQueryHandlerSpecs {

    Interpreter mockInterpreter;
    NumberMapping mockNumberMapping;
    NumeralMappingQueryHandler numeralMappingQueryHandler;

    @Before
    public void setUp() throws Exception {
        mockInterpreter = mock(Interpreter.class);
        mockNumberMapping = mock(NumberMapping.class);
        numeralMappingQueryHandler = new NumeralMappingQueryHandler(mockInterpreter, mockNumberMapping);
    }

    @Test
    public void itShouldReturnArabicNumberEquivalentOfGivenAlienNumber() {
        //Given
        String input = "how much is glob glob ?";
            //Expectations
            Query mockQuery = mock(Query.class);
            when(mockInterpreter.getRequestObjectFrom(input)).thenReturn(mockQuery);
            when(mockQuery.getNumber()).thenReturn(new String[]{"glob", "glob"});
            when(mockNumberMapping.getRomanOf("glob")).thenReturn("I");

        //When
        String actualOutput = numeralMappingQueryHandler.process(input);

        //Then
        String expectedOutput = "glob glob is 2";
        assertThat(actualOutput, is(expectedOutput));
    }
}