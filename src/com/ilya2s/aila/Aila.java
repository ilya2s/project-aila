package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.Blockchain;

public class Aila {
    private static final int NUMBER_OF_BLOCKS = 5;

    public static void main(String[] args) {
        Blockchain aila = new Blockchain();

        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            aila.generateBlock();
        }

        System.out.println("=====================");
        System.out.println("BLOCKCHAIN IS " + (aila.validate() ? "VALID" : "INVALID"));
        System.out.println("=====================");

        System.out.println(aila);


    }
}
