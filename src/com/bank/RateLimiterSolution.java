package com.bank;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterSolution {

    public static void main(String[] args) throws InterruptedException{
        RateLimiter rateLimiter = new RateLimiter(5, 2);
        System.out.println(rateLimiter.rateLimit(1));
        Thread.sleep(2000);
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        Thread.sleep(2000);
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
    }
}

class RateLimiter {
    int numberOfRequestAllowed;
    int numberOfSeconds;
    Map<Integer, RateLimiterConfig> mapConfig = new HashMap<>();

    RateLimiter(int numberOfRequestAllowed, int numberOfSeconds) {
        this.numberOfRequestAllowed = numberOfRequestAllowed;
        this.numberOfSeconds = numberOfSeconds;
    }

    boolean rateLimit(int customerId){

        RateLimiterConfig defaultRateLimiterConfig = new RateLimiterConfig(0, System.currentTimeMillis(), 0);
        RateLimiterConfig rateLimiterConfig = mapConfig.getOrDefault(customerId, defaultRateLimiterConfig);
        long currentTime = System.currentTimeMillis();
        int timeDiff = getDiffInSecond(currentTime, rateLimiterConfig.getTimeStamp());

        if(timeDiff < this.numberOfSeconds) {
            if(rateLimiterConfig.getCountOfRequestAllowed() < this.numberOfRequestAllowed){
                //allow request
                RateLimiterConfig rateLimiterConfig2 = new RateLimiterConfig(rateLimiterConfig.getCountOfRequestAllowed()+1, rateLimiterConfig.getTimeStamp(), rateLimiterConfig.getCreditRequest());
                this.mapConfig.put(customerId, rateLimiterConfig2);
                return true;
            } else if(rateLimiterConfig.getCreditRequest() > 0){
                //allow Request
                RateLimiterConfig rateLimiterConfig2 = new RateLimiterConfig(rateLimiterConfig.getCountOfRequestAllowed()+1, rateLimiterConfig.getTimeStamp(), rateLimiterConfig.getCreditRequest()-1);
                this.mapConfig.put(customerId, rateLimiterConfig2);
                return true;
            }
            else {
                //reject request
                return false;
            }
        } else {
            int creditLimitOFCurrentWindow = this.numberOfRequestAllowed > rateLimiterConfig.getCountOfRequestAllowed()? (this.numberOfRequestAllowed - rateLimiterConfig.getCountOfRequestAllowed()) : 0;
            RateLimiterConfig rateLimiterConfig2 = new RateLimiterConfig(1, currentTime, rateLimiterConfig.getCreditRequest() + creditLimitOFCurrentWindow);
            this.mapConfig.put(customerId, rateLimiterConfig2);
            return true;
        }
    }

    private int getDiffInSecond(long currentTime, long initialRequestTime) {
        return (int) (currentTime - initialRequestTime) / 1000;
    }
}
class Customer {
    int customerId;
    Customer(int customerId){
        this.customerId = customerId;
    }
}


class RateLimiterConfig {
    int countOfRequestAllowed;
    long timeStamp;
    int creditRequest;
    RateLimiterConfig(int countOfRequestAllowed, long timeStamp, int creditRequest) {
        this.countOfRequestAllowed = countOfRequestAllowed;
        this.timeStamp = timeStamp;
        this.creditRequest = creditRequest;
    }

    int getCountOfRequestAllowed() {
        return this.countOfRequestAllowed;
    }

    long getTimeStamp() {
        return this.timeStamp;
    }

    int getCreditRequest() {
        return this.creditRequest;
    }
}