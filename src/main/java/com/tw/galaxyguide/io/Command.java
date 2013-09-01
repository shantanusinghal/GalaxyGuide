package com.tw.galaxyguide.io;

import org.apache.commons.lang3.StringUtils;

public class Command {

    public interface Type {

        public enum Assignment implements Type {
            NUMERAL_MAPPING,
            CREDIT_INFO
        }

        public enum Query implements Type {
            HOW_MUCH,
            HOW_MANY
        }
    }

    public static class Response {
        public static final String ERROR = "I have no idea what you are talking about";
        public static final String SUCCESS = "Got it!";

        public static String howMuchQueryFormat(String[] query, String answer) {
            String alienNumberString = StringUtils.join(query, ' ').trim();
            return alienNumberString + " is " + answer;
        }

        public static String howManyQueryFormat(String[] alienNumbers, String arabicNumber) {
            return null;  //To change body of created methods use File | Settings | File Templates.
        }
    }
}
