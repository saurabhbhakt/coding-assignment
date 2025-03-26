package org.quarks.learn.collection.synchronize;

import java.util.*;

public class SynchronizedSetExample {
    public static void main(String[] args) {
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        set.add(1);
        set.add(2);
        set.add(3);

        // Use synchronized block for iteration
        synchronized (set) {
            for (int num : set) {
                System.out.println(num);
            }
        }
    }
}

