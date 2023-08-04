package com.ilya2s.aila.blockchain;

public class Miner {

    private final Blockchain blockchain;
    private final BlockFactory factory;

    public Miner(Blockchain blockchain) {
        this.blockchain = blockchain;
        this.factory = new AilaBlockFactory();
    }


    public Block mineBlock() {
        Block block = mine();
        offerBlock(block);

        return block;
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
        if (blockchain.isEmpty()) return factory.createGenesisBlock();

        return factory.createNewBlock(blockchain.size() + 1, blockchain.getLastBlock().getHash());
    }


    private void offerBlock(Block block) {
        blockchain.addBlock(block);
    }


}
