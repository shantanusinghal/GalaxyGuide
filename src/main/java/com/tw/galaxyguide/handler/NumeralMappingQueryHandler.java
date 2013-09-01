package com.tw.galaxyguide.handler;

import com.tw.galaxyguide.io.Interpreter;
import com.tw.galaxyguide.mapping.NumberMapping;
import com.tw.galaxyguide.io.Query;
import com.tw.galaxyguide.roman.RomanNumber;

import static com.tw.galaxyguide.io.Command.Type;
import static com.tw.galaxyguide.io.Command.Response;

public class NumeralMappingQueryHandler implements Handler {

    private Interpreter interpreter;
    private NumberMapping numberMapping;

    public NumeralMappingQueryHandler(Interpreter interpreter, NumberMapping numberMapping) {
        this.interpreter = interpreter;
        this.numberMapping = numberMapping;
    }

    @Override
    public Type getType() {
        return Type.Query.HOW_MUCH;
    }

    public String process(String input) {
        Query query = interpreter.getRequestObjectFrom(input);
        String[] alienNumbers = query.getNumber();
        String arabicNumber = howMuchIs(alienNumbers);
        return Response.howMuchQueryFormat(alienNumbers, arabicNumber);
    }

    public String howMuchIs(String[] alienNumbers) {
        String romanNumberString = getRomanEquivalentOf(alienNumbers);
        RomanNumber romanNumber = RomanNumber.valueOf(romanNumberString);
        return String.valueOf(romanNumber.toArabic());
    }

    private String getRomanEquivalentOf(String[] alienNumbers) {
        StringBuilder romanNumberBuilder = new StringBuilder();
        for (String alienNumber : alienNumbers) {
            romanNumberBuilder.append(numberMapping.getRomanOf(alienNumber));
        }
        return romanNumberBuilder.toString();
    }
}
