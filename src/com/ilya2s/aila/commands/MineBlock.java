package com.ilya2s.aila.commands;

import com.ilya2s.aila.blockchain.Blockchain;

public class MineBlock extends Command implements Executable {
    public MineBlock(Blockchain blockchain) {
        super(blockchain);
    }


    @Override
    public void execute() {
        System.out.println(blockchain.mineBlock());
    }
}
