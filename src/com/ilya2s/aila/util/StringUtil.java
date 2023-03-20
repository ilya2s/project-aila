package com.ilya2s.aila.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


/**
 * A utility class for working with strings.
 */
public final class StringUtil {
    /**
     * Computes the SHA-256 hash of the given input string.
     *
     * @param input the input string to be hashed
     * @return the SHA-256 hash of the input string, represented as a hexadecimal string
     * @throws RuntimeException if an error occurs during the hashing process
     */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();

            for (byte elem : hash) {

                // Add leading zero if the hex representation is only one character long to have 2 digit hex number
                String hex = Integer.toHexString(0xff & elem);

                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
