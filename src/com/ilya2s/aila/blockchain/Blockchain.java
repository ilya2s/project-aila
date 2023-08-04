package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.blockchain.block.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of a blockchain.
 */
public class Blockchain {
    private static final Blockchain INSTANCE = new Blockchain();
    private final List<Block> chain = new ArrayList<>();
    private boolean valid = true;


    /**
     * Creates a new blockchain. The constructor is private to respect the singleton desing patter for the Blockchain.
     * <p>
     * Initializes an empty chain and an instance of AilaBlockFactory.
     */
    private Blockchain() { }


    public boolean addBlock(Block newBlock) {
        if (!valid) return false;

        Block lastBlock = getLastBlock();

        if (validateNewBlock(newBlock, lastBlock)) {
            return chain.add(newBlock);
        }

        valid = false;
        return false;
    }


    private boolean validateNewBlock(Block newBlock, Block lastBlock) {
        if (lastBlock != null) {
            return newBlock.getPreviousHash().equals(lastBlock.getHash());
        }

        return newBlock.getPreviousHash().equals(Block.ZERO_HASH);
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
