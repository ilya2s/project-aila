package com.ilya2s.aila.blockchain;

import java.util.ArrayList;

public class Blockchain {
    private final ArrayList<Block> chain;
    private final BlockFactory factory;

    public Blockchain() {
        chain = new ArrayList<>();
        factory = new BlockFactory();

        this.chain.add(factory.createGenesisBlock());
    }

    public void generateBlock() {
        Block currentBlock = factory.createBlock(chain.size() + 1, chain.get(chain.size() - 1).getHash());

        chain.add(currentBlock);
    }

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
                    .append("----------------------------------------------------------------")
                    .append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
}
