package org.quarks.learn.java8;

import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String original = "Java 8 Base64 Encoding!";

        // Encoding a string to Base64
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        System.out.println("Encoded: " + encoded);

        // Decoding from Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decoded = new String(decodedBytes);
        System.out.println("Decoded: " + decoded);  // Output: Java 8 Base64 Encoding!
    }
}
