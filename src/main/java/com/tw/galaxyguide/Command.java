package com.tw.galaxyguide;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 9/1/13
 * Time: 9:25 AM
 */
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
    }
}
