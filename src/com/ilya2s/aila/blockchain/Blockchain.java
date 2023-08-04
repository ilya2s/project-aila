package com.ilya2s.aila.blockchain;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of a blockchain.
 */
public class Blockchain {
    private static final Blockchain INSTANCE = new Blockchain();
    private final List<Block> chain;


    /**
     * Creates a new blockchain. The constructor is private to respect the singleton desing patter for the Blockchain.
     * <p>
     * Initializes an empty chain and an instance of AilaBlockFactory.
     */
    private Blockchain() {
        chain = new ArrayList<>();
    }


    public void addBlock(Block block) {
        boolean chainIsValid = validate();

        Block last = getLastBlock();
        boolean newBlockIsValid;

        if (last != null) {
            newBlockIsValid = block.getPreviousHash().equals(last.getHash());
        } else {
            newBlockIsValid = block.getPreviousHash().equals(Block.ZERO_HASH);
        }

        if (chainIsValid && newBlockIsValid) {
            chain.add(block);
        }
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
     * @return The singleton instance of the Blockchain.
     */
    public static Blockchain getInstance() {
        return INSTANCE;
    }


    public boolean isEmpty() {
        return chain.isEmpty();
    }


    public int size() {
        return chain.size();
    }


    public Block getLastBlock() {
        if (chain.isEmpty()) return null;

        return chain.get(chain.size() - 1);
    }


    /**
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
