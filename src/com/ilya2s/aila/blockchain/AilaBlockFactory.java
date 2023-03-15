package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.Aila;
import com.ilya2s.aila.util.StringUtil;

/**
 * A factory for creating blocks in the blockchain.
 */
public class AilaBlockFactory implements BlockFactory {
    /**
     * Creates the genesis block in the blockchain.
     *
     * @return the genesis block
     */
    @Override
    public Block createGenesisBlock() {
        return createNewBlock(1, Block.ZERO_HASH);
    }


    /**
     * Creates a new block with the given ID and previous block hash.
     * @param id the block ID
     * @param previousHash the hash of the previous block in the blockchain
     * @return the new block
     */
    @Override
    public Block createNewBlock(int id, String previousHash) {
        return new Block(id, previousHash, Aila.DIFFICULTY);
    }
}
