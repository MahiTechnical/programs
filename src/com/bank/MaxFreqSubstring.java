package com.bank;

import java.util.HashMap;
import java.util.Map;

public class MaxFreqSubstring {

    public static void main(String[] args) {
        MaxFreqSubstring  maxFreqSubstring = new MaxFreqSubstring();
        int i = maxFreqSubstring.maxFreq("aababcaab",2, 3,  4);
        System.out.println(i);
    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> arr = new HashMap<>();

        int start=0, end=0,  count=0;
        int map[] = new int[256];

        while(end < s.length()) {
            char c = s.charAt(end);
            if(map[c]==0)count++;
            map[c]++;
            end++;

            while(end-start >= minSize && end-start <= maxSize){
                if(count<=maxLetters){
                    String sub = s.substring(start,end);
                    arr.put(sub, arr.getOrDefault(sub, 0)+1);
                }
                char c1 = s.charAt(start);
                if(map[c1]==1) count--;
                map[c1]--;
                start++;
            }
        }

        int max = 0;

        for(String str : arr.keySet()){
            max = Math.max(max, arr.get(str));
        }

        return max;
    }
}
