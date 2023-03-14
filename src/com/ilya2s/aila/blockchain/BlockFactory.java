package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;

public class BlockFactory {
    private final String genesisBlockHash;

    public BlockFactory() {
        genesisBlockHash = StringUtil.applySha256("0");
    }

    public Block createGenesisBlock() {
        return createBlock(1, genesisBlockHash);
    }

    public Block createBlock(int id, String previousHash) {
        return new Block(id, previousHash);
    }

}
