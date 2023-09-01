package com.ilya2s.aila.blockchain.miner;

import com.ilya2s.aila.Aila;
import com.ilya2s.aila.blockchain.Blockchain;
import com.ilya2s.aila.blockchain.block.AilaBlockFactory;
import com.ilya2s.aila.blockchain.block.Block;
import com.ilya2s.aila.blockchain.block.BlockFactory;

public class Miner {

    private final Blockchain blockchain;
    private final BlockFactory factory = new AilaBlockFactory();

    public Miner(Blockchain blockchain) {
        this.blockchain = blockchain;
    }


    public Block mineBlock() {
        Block block;

        while (true) {
            block = mine();

            if (offerBlock(block)) return block;
        }
    }


    /**
     * Mines a new block and adds it to the blockchain.
     * <p>
     * If the chain is empty, a genesis block is mined. Otherwise, a new block is mined
     * with the appropriate ID and previous block hash.
     *
     * @return the mined block
     */
    private Block mine() {
        return factory.createNewBlock(blockchain.getLatestBlockHash());
    }


    private boolean offerBlock(Block block) {
        return blockchain.addBlock(block);
    }
}
