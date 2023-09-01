package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.Blockchain;
import com.ilya2s.aila.blockchain.miner.Miner;
import com.ilya2s.aila.command.Controller;
import com.ilya2s.aila.blockchain.miner.MineBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * The main class for the Aila blockchain application.
 */
public class Aila {
    public static final int NUMBER_OF_BLOCKS = 9;
    public static int DIFFICULTY = 0;
    public static final AtomicInteger nextID = new AtomicInteger(1);

    public static void main(String[] args) {
        Blockchain aila = Blockchain.getInstance();
        Miner blockMiner = new Miner(aila);         // Receiver for Mining

        Controller controller = new Controller();   // Invoker

        // Commands
        MineBlock mineBlock = new MineBlock(blockMiner);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println(aila.getLastBlock());

        controller.setCommand(mineBlock);
        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            executor.submit(controller::executeCommand);
        }

        executor.shutdown();


        try {
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();

                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("ExecutorService did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("======================================");
        System.out.println(aila);
    }
}
