package com.ilya2s.aila.command;

public class Controller {
    private Executable command;


    public void setCommand(Executable command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

}
