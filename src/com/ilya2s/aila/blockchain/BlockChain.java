package com.ilya2s.aila.blockchain;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {

    private final List<Block> blockChain;

    public BlockChain() {
        this.blockChain = new LinkedList<>();
    }

    public void generateBlock() {
        if (this.blockChain.isEmpty()) {
            Block firstBlock = new Block("0");
            this.blockChain.add(firstBlock);
        } else {
            Block previousBlock = this.blockChain.get(this.blockChain.size() - 1);
            Block currentBlock = new Block(previousBlock.hash);

            this.blockChain.add(currentBlock);
        }
    }

    public boolean validate() {
        if (this.blockChain.isEmpty()) return true;

        Block currentBlock;
        Block previousBlock;
        for (int i = 1; i < this.blockChain.size(); i++) {
            currentBlock = this.blockChain.get(i);
            previousBlock = this.blockChain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.makeHash())) {
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Block block : blockChain) {
            output.append(block).append(System.getProperty("line.separator"));
        }

        return output.toString();
    }

}
