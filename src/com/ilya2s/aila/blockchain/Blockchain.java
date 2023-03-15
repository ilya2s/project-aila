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
     * Creates a new blockchain with a genesis block.
     */
    public Blockchain() {
        chain = new ArrayList<>();
        factory = new AilaBlockFactory();

        chain.add(factory.createGenesisBlock());
    }


    /**
     * Generates a new block in the blockchain.
     */
    public Block generateBlock() {
        Block currentBlock = factory.createNewBlock(chain.size() + 1, chain.get(chain.size() - 1).getHash());
        chain.add(currentBlock);

        return currentBlock;
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
