package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.io.Command;
import com.tw.galaxyguide.mapping.NumberMapping;
import com.tw.galaxyguide.request.NumeralMappingQueryRequest;
import com.tw.galaxyguide.request.Request;
import com.tw.galaxyguide.roman.RomanNumber;

import static com.tw.galaxyguide.io.Command.Type;

public class NumeralMappingQueryHandler implements Handler {

    private NumberMapping numberMapping;

    public NumeralMappingQueryHandler(NumberMapping numberMapping) {
        this.numberMapping = numberMapping;
    }

    @Override
    public Type getType() {
        return Type.Query.HOW_MUCH;
    }

    @Override
    public <T extends Request> String process(T requestObj) {
        NumeralMappingQueryRequest request = (NumeralMappingQueryRequest) requestObj;
        String[] alienNumbers = request.getAlienNumbers();
        String answer = howMuchIs(alienNumbers);
        return request.responseWith(answer);
    }

    public String howMuchIs(String[] alienNumbers) {
        String romanNumberString = getRomanEquivalentOf(alienNumbers);
        RomanNumber romanNumber = RomanNumber.valueOf(romanNumberString);
        return String.valueOf(romanNumber.toArabic());
    }

    private String getRomanEquivalentOf(String[] alienNumbers) {
        StringBuilder romanNumberBuilder = new StringBuilder();
        for (String alienNumber : alienNumbers) {
            romanNumberBuilder.append(numberMapping.getRomanOf(alienNumber).toString());
        }
        return romanNumberBuilder.toString();
    }
}
