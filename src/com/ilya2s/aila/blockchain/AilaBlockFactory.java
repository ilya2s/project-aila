package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.Aila;

/**
 * A factory for creating blocks in the blockchain.
 */
public class AilaBlockFactory implements BlockFactory {

    /**
     * Creates the genesis block in the blockchain.
     * <p>
     * The genesis block is the first block in the blockchain and has an ID of 1 and the
     * predefined previous hash value of Block.ZERO_HASH.
     *
     * @return the genesis block
     */
    @Override
    public Block createGenesisBlock() {
        return createNewBlock(1, Block.ZERO_HASH);
    }


    /**
     * Creates a new block with the given ID and previous block hash.
     * <p>
     * The new block is created with the specified ID and previous block hash, and the mining difficulty
     * is set according to the <code>Aila.DIFFICULTY</code> constant.
     *
     * @param id          the block ID
     * @param previousHash the hash of the previous block in the blockchain
     * @return the new block
     */
    @Override
    public Block createNewBlock(int id, String previousHash) {
        return new Block(id, previousHash, Aila.DIFFICULTY);
    }
}
