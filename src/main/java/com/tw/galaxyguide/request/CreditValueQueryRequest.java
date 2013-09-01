package com.tw.galaxyguide.request;

import com.tw.galaxyguide.io.Command;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static com.tw.galaxyguide.io.Command.Type;

public class CreditValueQueryRequest implements Request {

    private String input;

    public CreditValueQueryRequest(String input) {
        this.input = input;
    }

    @Override
    public Type getType() {
        return Type.Query.HOW_MANY;
    }

    public String[] getAlienNumbers() {
        String[] rValues = input.split("is")[1].split(" ");
        int secondLastElementIndex = rValues.length - 2;
        return Arrays.copyOf(rValues, secondLastElementIndex);
    }

    public String getElement() {
        String[] rValues = input.split("is")[1].split(" ");
        int secondLastElementIndex = rValues.length - 2;
        return rValues[secondLastElementIndex];
    }

    public String responseWith(String answer) {
        return StringUtils.join(getAlienNumbers(), ' ') + getElement() + " is " + answer + " Credits";
    }
}
