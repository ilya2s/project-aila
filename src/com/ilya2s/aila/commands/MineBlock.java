package com.ilya2s.aila.commands;

import com.ilya2s.aila.blockchain.Miner;

public class MineBlock implements Executable {

    private final Miner miner;

    public MineBlock(Miner miner) {
        this.miner = miner;
    }


    @Override
    public void execute() {
        System.out.println(miner.mineBlock());
    }
}
