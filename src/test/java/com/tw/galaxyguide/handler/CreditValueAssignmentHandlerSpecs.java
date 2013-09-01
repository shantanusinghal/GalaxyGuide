package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.io.Command;
import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.mapping.CurrencyMapping;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 9/1/13
 * Time: 11:53 AM
 */
public class CreditValueAssignmentHandlerSpecs {

    Interpreter interpreter;
    CurrencyMapping currencyMapping;
    NumeralMappingQueryHandler numeralMappingQueryHandler;
    CreditValueAssignmentHandler creditValueAssignmentHandler;

    @Before
    public void setUp() throws Exception {
        interpreter = mock(Interpreter.class);
        currencyMapping = mock(CurrencyMapping.class);
        numeralMappingQueryHandler = mock(NumeralMappingQueryHandler.class);
        creditValueAssignmentHandler = new CreditValueAssignmentHandler(interpreter, currencyMapping, numeralMappingQueryHandler);
    }

    @Test
    public void itShouldStoreCreditValueOfElement() {
        //Given
        String input = "glob glob Silver is 34 Credits";
        Assignment mockAssignment = mock(Assignment.class);
            //Expectations
            when(interpreter.getAssignmentObjectFrom(input)).thenReturn(mockAssignment);
            when(mockAssignment.getRhs()).thenReturn(new String[]{"34", "Credits"});
            when(mockAssignment.getLhs()).thenReturn(new String[]{"glob", "glob", "Silver"});
            when(numeralMappingQueryHandler.howMuchIs(new String[]{"glob", "glob"})).thenReturn("2");

        //When
        String actualOutput = creditValueAssignmentHandler.process(input);

        //Then
        verify(currencyMapping).add("Silver", "17");
        assertThat(actualOutput, is(Command.Response.SUCCESS));
    }
}
