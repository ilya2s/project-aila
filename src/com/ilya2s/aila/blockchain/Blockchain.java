package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.Aila;
import com.ilya2s.aila.blockchain.block.AilaBlockFactory;
import com.ilya2s.aila.blockchain.block.Block;
import com.ilya2s.aila.blockchain.block.BlockFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A simple implementation of a blockchain.
 */
public class Blockchain {
    private static final Blockchain INSTANCE = new Blockchain();
    private final List<Block> chain = new ArrayList<>();
    private final PriorityBlockingQueue<Block> pendingBlocks = new PriorityBlockingQueue<>(Aila.NUMBER_OF_BLOCKS,
            Comparator.comparing(Block::getId));
    private final AtomicReference<String> latestBlockHash = new AtomicReference<>();


    /**
     * Creates a new blockchain. The constructor is private to respect the singleton desing patter for the Blockchain.
     * <p>
     * Initializes an empty chain and an instance of AilaBlockFactory.
     */
    private Blockchain() {
        BlockFactory factory = new AilaBlockFactory();
        addBlock(factory.createGenesisBlock());
    }


    public synchronized boolean addBlock(Block newBlock) {
        Block lastBlock = getLastBlock();

        if (validateNewBlock(newBlock, lastBlock)) {
            newBlock.setId(Aila.nextID.getAndIncrement());
            chain.add(newBlock);

            long generationTime = newBlock.getGenerationTime().toSeconds();
            if (generationTime < 1) Aila.DIFFICULTY++;
            if (generationTime > 60) Aila.DIFFICULTY--;

            latestBlockHash.set(newBlock.getHash());

            while (!pendingBlocks.isEmpty()) {
                Block nextBlock = pendingBlocks.peek();
                if (validateNewBlock(nextBlock, getLastBlock())) {
                    Block block = pendingBlocks.poll();
                    if (block != null) block.setId(Aila.nextID.getAndIncrement());
                    chain.add(block);

                    latestBlockHash.set(nextBlock.getHash());
                } else {
                    break;
                }
            }

            return true;
        } else {
            pendingBlocks.add(newBlock);
            return false;
        }
    }


    private boolean validateNewBlock(Block newBlock, Block lastBlock) {
        if (lastBlock != null) {
            return newBlock.getPreviousHash().equals(getLatestBlockHash());
        }

        return newBlock.getPreviousHash().equals(Block.ZERO_HASH);
    }

    public String getLatestBlockHash() {
        return latestBlockHash.get();
    }

    /**
     * @return The singleton instance of the Blockchain.
     */
    public static Blockchain getInstance() {
        return INSTANCE;
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
                    .append("\n");
        }
        return output.toString();
    }
}
