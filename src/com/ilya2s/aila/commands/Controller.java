package com.ilya2s.aila.commands;

public class Controller {
    private Executable command;


    public void setCommand(Executable command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

}
