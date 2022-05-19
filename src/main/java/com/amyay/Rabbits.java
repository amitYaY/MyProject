package com.amyay;

import java.util.*;

public class Rabbits {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        int[] counts = {1,2,2,2,2,2,2,2};
        System.out.println(findMinCount(counts));
    }

    private static int findMinCount(int[] counts) {

        if(counts.length == 0) {
            return 0;
        }

        for(int count : counts) {
            map.put(count, map.getOrDefault(count, 0)+1);
        }
        Set<Integer> keys = map.keySet();
        Iterator<Integer> it = keys.iterator();

        int minCount = 0;

        while (it.hasNext()) {
            int key = it.next();
            int count = map.get(key);
            int d = count / (key + 1);
            int r = count % (key + 1);
            if (d != 0) {
                minCount += (key+1)*d;
            }
            if(r != 0) {
                minCount += key + 1;
            }
        }
        return minCount;
    }

}
