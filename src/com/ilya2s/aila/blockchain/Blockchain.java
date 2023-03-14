package com.ilya2s.aila.blockchain;

import java.util.ArrayList;
import java.util.LinkedList;

public class Blockchain {
    private final ArrayList<Block> blockchain;

    public Blockchain() {
        blockchain = new ArrayList<>();
    }

    public void generateBlock() {
        String previousHash = blockchain.isEmpty() ? "0" : blockchain.getLast().getHash();
        blockchain.add(new Block(previousHash));
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
