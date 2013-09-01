package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.request.CreditValueQueryRequest;
import com.tw.galaxyguide.request.Request;
import com.tw.galaxyguide.mapping.CurrencyMapping;

import static com.tw.galaxyguide.io.Command.Type;

public class CreditValueQueryHandler implements Handler {

    private CurrencyMapping currencyMapping;
    private NumeralMappingQueryHandler numeralMappingQueryHandler;

    public CreditValueQueryHandler(CurrencyMapping currencyMapping, NumeralMappingQueryHandler numeralMappingQueryHandler) {
        this.currencyMapping = currencyMapping;
        this.numeralMappingQueryHandler = numeralMappingQueryHandler;
    }


//    @Override
//    public String process(String input) {
//        Query query = interpreter.getRequestObject(input);
//        String element = query.getElement();
//        String[] alienNumbers = query.getNumber();
//        String answer = numeralMappingQueryHandler.howMuchIs(alienNumbers);
//        currencyMapping.
//        return Query.formatResponse(answer);
//    }

    @Override
    public Type getType() {
        return Type.Query.HOW_MANY;
    }

    @Override
    public <T extends Request> String process(T requestObj) {
        CreditValueQueryRequest request = (CreditValueQueryRequest) requestObj;
        int quantity = getElementQuantityFrom(request);
        int creditValue = getElementCreditValueFrom(request);
        String answer = String.valueOf(quantity*creditValue);
        return request.responseWith(answer);
    }

    private int getElementCreditValueFrom(CreditValueQueryRequest request) {
        String element = request.getElement();
        return currencyMapping.getValueOf(element);
    }

    private int getElementQuantityFrom(CreditValueQueryRequest request) {
        String[] alienNumbers = request.getAlienNumbers();
        String elementQuantityInString = numeralMappingQueryHandler.howMuchIs(alienNumbers);
        return Integer.parseInt(elementQuantityInString);
    }
}
