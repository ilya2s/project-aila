package com.ilya2s.aila;

import com.ilya2s.aila.blockchain.Blockchain;
import com.ilya2s.aila.commands.Controller;
import com.ilya2s.aila.commands.MineBlock;
import com.ilya2s.aila.commands.ValidateChain;

/**
 * The main class for the Aila blockchain application.
 */
public class Aila {
    public static final int NUMBER_OF_BLOCKS = 5;
    public static final int DIFFICULTY = 4;

    public static void main(String[] args) {
        Blockchain aila = Blockchain.getInstance();
        Controller controller = new Controller();

        MineBlock mineBlock = new MineBlock(aila);
        ValidateChain validateChain = new ValidateChain(aila);

        controller.setCommand(mineBlock);
        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            controller.executeCommand();
        }

        controller.setCommand(validateChain);
        controller.executeCommand();
    }
}
