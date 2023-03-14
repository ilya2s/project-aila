package com.ilya2s.aila.blockchain;

import java.util.ArrayList;

public class Blockchain {
    private final ArrayList<Block> blockchain;
    private final BlockFactory blockFactory;

    public Blockchain() {
        blockchain = new ArrayList<>();
        blockFactory = new BlockFactory();

        this.blockchain.add(blockFactory.createGenesisBlock());
    }

    public Block generateBlock() {
        Block currentBlock = blockFactory
                .createBlock(blockchain.size(), blockchain.get(blockchain.size() - 1).getHash());

        blockchain.add(currentBlock);
    }

    public boolean validate() {
        if (blockchain.isEmpty()) return true;

        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

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

        for (Block block : blockchain) {
            output
                    .append(block)
                    .append("----------------------------------------------------------------")
                    .append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
}
