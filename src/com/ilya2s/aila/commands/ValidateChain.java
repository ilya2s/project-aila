package com.ilya2s.aila.commands;

import com.ilya2s.aila.blockchain.Blockchain;

public class ValidateChain extends Command implements Executable {

    public ValidateChain(Blockchain blockchain) {
        super(blockchain);
    }

    @Override
    public void execute() {
        System.out.println("=====================");
        System.out.println("BLOCKCHAIN IS " + (blockchain.validate() ? "VALID" : "INVALID"));
        System.out.println("=====================");
    }
}
