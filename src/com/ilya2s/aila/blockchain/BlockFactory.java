package com.ilya2s.aila.blockchain;

/**
 * An interface for creating blocks in the blockchain.
 */
public interface BlockFactory {

    Block createGenesisBlock();
    Block createNewBlock(int id, String previousHash);
}
