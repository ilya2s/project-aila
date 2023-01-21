package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.BlockChain;

public class Aila {
    private static final int NUMBER_OF_BLOCKS = 5;

    public static void main(String[] args) {
        BlockChain aila = new BlockChain();

        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            aila.generateBlock();
        }

        System.out.println("=====================");
        System.out.println("BLOCKCHAIN IS " + (aila.validate() ? "VALID" : "INVALID"));
        System.out.println("=====================");

        System.out.println(aila);


    }
}
