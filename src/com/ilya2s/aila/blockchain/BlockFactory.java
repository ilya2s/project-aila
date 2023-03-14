package com.ilya2s.aila.blockchain;

public interface BlockFactory {

    Block createGenesisBlock();
    Block createNewBlock(int id, String previousHash);
}
