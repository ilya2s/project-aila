package com.ilya2s.aila.blockchain;

public class Miner {

    private final Blockchain blockchain;
    private final BlockFactory factory;

    public Miner(Blockchain blockchain) {
        this.blockchain = blockchain;
        this.factory = new AilaBlockFactory();
    }


    public Block mineBlock() {
        Block block;

        block = mine();





        return block;
    }


    private Block mine() {
        if (blockchain.isEmpty()) return factory.createGenesisBlock();

        return factory.createNewBlock(blockchain.size() + 1, blockchain.getLastBlock().getHash());
    }


    // TODO: Offer block to blockchain


}
