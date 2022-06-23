package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.BlockChain;

public class Aila {

    public static void main(String[] args) {

        BlockChain aila = new BlockChain();

        aila.generateBlock();
        aila.generateBlock();
        aila.generateBlock();
        aila.generateBlock();
        aila.generateBlock();

        System.out.println(aila.validate());

        System.out.println(aila);

    }
}
