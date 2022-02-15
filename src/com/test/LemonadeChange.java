package com.test;

import java.util.HashMap;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/****
 * Time Complexity: O(N), where NN is the length of bills.
 *
 * Space Complexity: O(1)
 */


public class LemonadeChange {

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();

        int bills [] = new int[]{5,5,5,10,20,10,10};
        //assertTrue(lemonadeChange.evaluate(bills));

        System.out.println((lemonadeChange.evaluate(bills)));
    }

    private boolean evaluate(int[] bills) {

        HashMap<Integer,Integer> changeMap = new HashMap<>();
        changeMap.put(5,0);
        changeMap.put(10,0);

        for(int bill : bills){

            if(bill == 5){
                changeMap.put(5,changeMap.getOrDefault(5,0)+1);

            }else if(bill ==10){
                if(changeMap.get(5) == 0) return false;
                changeMap.put(5,changeMap.getOrDefault(5,0)-1);
                changeMap.put(10,changeMap.getOrDefault(10,0)+1);
            }else if(bill==20){

                if(changeMap.get(10) ==0) {
                    if (changeMap.get(5) < 3) return false;

                    changeMap.put(5,changeMap.get(5)-3);
                }else {
                    if (changeMap.get(5) ==0) return false;
                    changeMap.put(5, changeMap.getOrDefault(5, 0) - 1);
                    changeMap.put(10, changeMap.getOrDefault(10, 0) - 1);
                }
            }

        }
        return true;
    }
}
