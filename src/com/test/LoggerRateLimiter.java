package com.test;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    private final Map<String, Integer> messageToTime;

    public LoggerRateLimiter() {
        messageToTime = new HashMap<>();
    }

    public static void main(String[] args) {
        LoggerRateLimiter  loggerRateLimiter = new LoggerRateLimiter();

        System.out.println(loggerRateLimiter.shouldPrintMessage(1, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(2, "bar"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(3, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(8, "bar"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(10, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(11, "foo"));

    }

    private boolean shouldPrintMessage(int timestamp, String message){

        if (!messageToTime.containsKey(message)) {
            messageToTime.put(message, timestamp);
            return true;
        }

        int prev = messageToTime.get(message);
        if (timestamp - prev >= 10) {
            messageToTime.put(message, timestamp);
            return true;
        }

        return false;
    }
}
