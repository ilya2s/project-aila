package com.ilya2s.aila.blockchain;

import java.util.ArrayList;

/**
 * A simple implementation of a blockchain.
 */
public class Blockchain {
    private final ArrayList<Block> chain;
    private final BlockFactory factory;


    /**
     * Creates a new blockchain with a genesis block.
     */
    public Blockchain() {
        chain = new ArrayList<>(100);   // Initial capacity of 100
        factory = new BlockFactory();

        chain.add(factory.createGenesisBlock());
    }


    /**
     * Generates a new block in the blockchain.
     */
    public void generateBlock() {
        Block currentBlock = factory.createBlock(chain.size() + 1, chain.get(chain.size() - 1).getHash());
        chain.add(currentBlock);
    }


    /**
     * Validates the blockchain by checking the hashes of all blocks.
     *
     * @return true if the block is valid, false otherwise
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
