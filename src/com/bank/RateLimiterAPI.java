package com.bank;

import java.util.HashMap;
import static org.junit.Assert.assertFalse;

/**
 *
 */
public class RateLimiterAPI {
//james Navin

    /**
     * Perform rate limiting logic for provided customer ID. Return true if the
     * // request is allowed, and false if it is not.
     * boolean rateLimit(int customerId)
     * <p>
     * int customer1 = 1;
     * assertTrue(rateLimiter.evaluate(customer1));
     * assertFalse(rateLimiter.evaluate(customer1));
     * assertFalse(rateLimiter.evaluate(customer1));
     **/


    private int THERSOLd = 10;
    HashMap<Integer, Integer> rateLimiterMap = new HashMap<>();

    public static void main(String[] args) {

        RateLimiterAPI rateLimiterAPI = new RateLimiterAPI();
        rateLimiterAPI.reset(101);
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        rateLimiterAPI.reset(101);
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));
        rateLimiterAPI.reset(102);
        System.out.println(rateLimiterAPI.evaluate(101));
        System.out.println(rateLimiterAPI.evaluate(101));


    }

    /**
     *
     * @param customerId
     */
    private void reset(int customerId) {
        rateLimiterMap.put(customerId, 0);
    }

    /**
     *
     * @param customerId
     * @return
     */
    private boolean evaluate(int customerId) {
        boolean check = false;
        if (rateLimiterMap.containsKey(customerId)) {
            int tm = rateLimiterMap.get(customerId);
            if (tm < THERSOLd) {
                tm = tm + 1;
                rateLimiterMap.put(customerId, tm);
                check = true;
            }
        } else {
            rateLimiterMap.put(customerId, 1);
            check = true;
        }
        return check;
    }
}
