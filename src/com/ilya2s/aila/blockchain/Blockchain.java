package com.ilya2s.aila.blockchain;

import java.util.LinkedList;

public class Blockchain {
    private final LinkedList<Block> chain;

    public Blockchain() {
        Block.idCount = 0;
        chain = new LinkedList<>();
    }

    public void generateBlock() {
        String previousHash = chain.isEmpty() ? "0" : chain.getLast().getHash();
        chain.add(new Block(previousHash));
    }

    public boolean validate() {
        if (chain.isEmpty()) return true;

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
                    .append("----------------------------------------------------------------")
                    .append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
}
