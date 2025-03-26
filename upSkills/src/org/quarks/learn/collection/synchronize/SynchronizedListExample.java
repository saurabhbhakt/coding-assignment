package org.quarks.learn.collection.synchronize;

import java.util.*;

public class SynchronizedListExample {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);

        // Use synchronized block for iteration
        synchronized (list) {
            for (int num : list) {
                System.out.println(num);
            }
        }
    }
}

