package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.Blockchain;

/**
 * The main class for the Aila blockchain application.
 */
public class Aila {
    public static final int NUMBER_OF_BLOCKS = 5;
    public static final int DIFFICULTY = 6;

    public static void main(String[] args) {
        Blockchain aila = Blockchain.getInstance();

        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            System.out.println(aila.mineBlock());
        }

        System.out.println("=====================");
        System.out.println("BLOCKCHAIN IS " + (aila.validate() ? "VALID" : "INVALID"));
        System.out.println("=====================");
    }
}
