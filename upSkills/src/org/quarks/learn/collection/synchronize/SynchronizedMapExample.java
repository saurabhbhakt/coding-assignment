package org.quarks.learn.collection.synchronize;

import java.util.*;

public class SynchronizedMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        // Use synchronized block for iteration
        synchronized (map) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
