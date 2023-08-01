package com.ilya2s.aila.commands;

import com.ilya2s.aila.blockchain.Blockchain;

public class ValidateChain implements Executable {

    private final Blockchain blockchain;

    public ValidateChain(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public void execute() {
        System.out.println("=====================");
        System.out.println("BLOCKCHAIN IS " + (blockchain.validate() ? "VALID" : "INVALID"));
        System.out.println("=====================");
    }
}
