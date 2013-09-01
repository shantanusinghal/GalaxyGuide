package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.mapping.CurrencyMapping;
import com.tw.galaxyguide.request.CreditValueAssignmentRequest;
import com.tw.galaxyguide.request.Request;

import static com.tw.galaxyguide.io.Command.Type;
import static com.tw.galaxyguide.io.Command.Response;

public class CreditValueAssignmentHandler implements Handler {
    private CurrencyMapping currencyMapping;
    private NumeralMappingQueryHandler numeralMappingQueryHandler;

    public CreditValueAssignmentHandler(CurrencyMapping currencyMapping, NumeralMappingQueryHandler numeralMappingQueryHandler) {
        this.currencyMapping = currencyMapping;
        this.numeralMappingQueryHandler = numeralMappingQueryHandler;
    }

    @Override
    public Type getType() {
        return Type.Assignment.CREDIT_INFO;
    }

    @Override
    public <T extends Request> String process(T requestObj) {
        CreditValueAssignmentRequest request = (CreditValueAssignmentRequest) requestObj;
        String key = request.getElement();
        String value = getElementsCreditValueFrom(request);
        currencyMapping.add(key, value);
        return Response.SUCCESS;
    }

    private String getElementsCreditValueFrom(CreditValueAssignmentRequest request) {
        int elementQuantity = getElementQuantityFrom(request);
        int creditAmount = Integer.parseInt(request.getCreditAmount());
        return String.valueOf(creditAmount / elementQuantity);
    }

    private int getElementQuantityFrom(CreditValueAssignmentRequest request) {
        String[] alienNumbers = request.getAlienNumbers();
        String elementQuantityString = numeralMappingQueryHandler.howMuchIs(alienNumbers);
        return Integer.parseInt(elementQuantityString);
    }

}
