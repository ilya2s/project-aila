package com.ilya2s.aila.commands;

import com.ilya2s.aila.blockchain.Blockchain;

public abstract class Command {
    protected final Blockchain blockchain;


    public Command(Blockchain blockchain) {
        this.blockchain = blockchain;
    }
}
