package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.Blockchain;
import com.ilya2s.aila.blockchain.miner.Miner;
import com.ilya2s.aila.command.Controller;
import com.ilya2s.aila.blockchain.miner.MineBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The main class for the Aila blockchain application.
 */
public class Aila {
    public static final int NUMBER_OF_BLOCKS = 5;
    public static final int DIFFICULTY = 4;

    public static void main(String[] args) {
        Blockchain aila = Blockchain.getInstance();
        Miner blockMiner = new Miner(aila);         // Receiver for Mining

        Controller controller = new Controller();   // Invoker

        // Commands
        MineBlock mineBlock = new MineBlock(blockMiner);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        controller.setCommand(mineBlock);
        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            executor.submit(controller::executeCommand);
        }

        executor.shutdown();
    }
}
