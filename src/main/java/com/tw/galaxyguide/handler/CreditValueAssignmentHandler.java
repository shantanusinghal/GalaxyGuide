package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.io.Assignment;
import com.tw.galaxyguide.mapping.CurrencyMapping;
import com.tw.galaxyguide.io.Interpreter;

import java.util.Arrays;

import static com.tw.galaxyguide.io.Command.Type;
import static com.tw.galaxyguide.io.Command.Response;

public class CreditValueAssignmentHandler implements Handler {
    private Interpreter interpreter;
    private CurrencyMapping currencyMapping;
    private NumeralMappingQueryHandler numeralMappingQueryHandler;

    public CreditValueAssignmentHandler(Interpreter interpreter, CurrencyMapping currencyMapping, NumeralMappingQueryHandler numeralMappingQueryHandler) {
        this.interpreter = interpreter;
        this.currencyMapping = currencyMapping;
        this.numeralMappingQueryHandler = numeralMappingQueryHandler;
    }

    @Override
    public Type getType() {
        return Type.Assignment.CREDIT_INFO;
    }

    @Override
    public String process(String input) {
        Assignment assignment = interpreter.getAssignmentObjectFrom(input);
        String key = getElementKeyFrom(assignment);
        String value = getElementsCreditValueFrom(assignment);
        currencyMapping.add(key, value);
        return Response.SUCCESS;
    }

    private String getElementsCreditValueFrom(Assignment assignment) {
        int elementQuantity = getElementQuantityFrom(assignment);
        int creditAmount = getCreditAmountFrom(assignment);
        return String.valueOf(creditAmount/elementQuantity);
    }

    private int getElementQuantityFrom(Assignment assignment) {
        String[] alienNumbers = getAlienNumberFrom(assignment);
        String elementQuantityString = numeralMappingQueryHandler.howMuchIs(alienNumbers);
        return Integer.parseInt(elementQuantityString);
    }

    private int getCreditAmountFrom(Assignment assignment) {
        String creditAmountString = assignment.getRhs()[0];
        return Integer.parseInt(creditAmountString);
    }

    private String[] getAlienNumberFrom(Assignment assignment) {
        String[] lhs = assignment.getLhs();
        return Arrays.copyOf(lhs, lhs.length - 1);
    }

    private String getElementKeyFrom(Assignment assignment) {
        String[] lhs = assignment.getLhs();
        return lhs[lhs.length - 1];
    }
}
