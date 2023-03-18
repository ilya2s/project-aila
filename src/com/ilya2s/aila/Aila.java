package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.Blockchain;

/**
 * Hi, this is a comment from Aila.
 */
public class Aila {
    public static final int NUMBER_OF_BLOCKS = 5;
    public static final int DIFFICULTY = 6;

    public static void main(String[] args) {
        Blockchain aila = new Blockchain();

        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            System.out.println(aila.generateBlock());
        }

        System.out.println("=====================");
        System.out.println("BLOCKCHAIN IS " + (aila.validate() ? "VALID" : "INVALID"));
        System.out.println("=====================");
    }
}
