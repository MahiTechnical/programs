package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer> {

    public int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F,true);
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1,1);
        lruCache.get(1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

        lruCache.put(4,4);
        System.out.println(lruCache.get(3));

    }

    private int get(int key) {
        return super.getOrDefault(key,-1);

    }

    private void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > capacity;
    }
}
