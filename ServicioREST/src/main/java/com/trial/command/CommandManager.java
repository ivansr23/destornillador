package com.trial.command;

import java.util.HashMap;

public class CommandManager {

    private static CommandManager commandManager;

    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =
            new HashMap<String, Class<? extends ICommand>>();

    public static synchronized CommandManager getIntance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
    }
    private CommandManager() {
        registCommand(MiComando.COMMAND_NAME, MiComando.class);
    }


    public ICommand getCommand(String commandName) throws IllegalAccessException, InstantiationException {
        return COMMANDS.get(commandName.toUpperCase()).newInstance();
    }

    public void registCommand(String commandName,
            Class<? extends ICommand> command) {
        COMMANDS.put(commandName.toUpperCase(), command);
    }
}