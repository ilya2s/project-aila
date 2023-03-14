package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;

/**
 * A factory for creating blocks in the blockchain.
 */
public class BlockFactory {
    private final String genesisBlockHash;


    /**
     * Creates a new block factory.
     */
    public BlockFactory() {
        genesisBlockHash = StringUtil.applySha256(Block.ZERO_HASH);
    }


    /**
     * Creates the genesis block in the blockchain.
     *
     * @return the genesis block
     */
    public Block createGenesisBlock() {
        return createBlock(1, genesisBlockHash);
    }


    /**
     * Creates a new block with the given ID and previous block hash.
     * @param id the block ID
     * @param previousHash the hash of the previous block in the blockchain
     * @return the new block
     */
    public Block createBlock(int id, String previousHash) {
        return new Block(id, previousHash);
    }
}
