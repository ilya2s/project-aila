package com.ilya2s.aila.blockchain;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of a blockchain.
 */
public class Blockchain {
    private final List<Block> chain;
    private final AilaBlockFactory factory;


    /**
     * Creates a new blockchain.
     * <p>
     * Initializes an empty chain and an instance of AilaBlockFactory.
     */
    public Blockchain() {
        chain = new ArrayList<>();
        factory = new AilaBlockFactory();
    }


    /**
     * Mines a new block and adds it to the blockchain.
     * <p>
     * If the chain is empty, a genesis block is mined. Otherwise, a new block is mined
     * with the appropriate ID and previous block hash. The new block is added to the chain.
     *
     * @return the mined block
     */
    public Block mineBlock() {
        Block block;
        if (chain.isEmpty()) {
            block = factory.createGenesisBlock();
        } else {
            block = factory.createNewBlock(chain.size() + 1, chain.get(chain.size() -1).getHash());
        }

        chain.add(block);

        return block;
    }


    /**
     * Validates the blockchain by checking the hashes of all blocks.
     * <p>
     * Ensures that each block's hash matches its computed hash and that
     * the previous block hash matches the current block's stored previous hash.
     *
     * @return true if the blockchain is valid, false otherwise
     */
    public boolean validate() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.makeHash())) {
                return false;
            }

            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Returns a string representation of the blockchain.
     *
     * @return the string representation of the blockchain
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (Block block : chain) {
            output
                    .append(block)
                    .append("----------------------------------------------------------------\n");
        }
        return output.toString();
    }
}
