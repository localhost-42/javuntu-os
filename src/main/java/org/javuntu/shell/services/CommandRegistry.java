package org.javuntu.shell.services;

import org.javuntu.exceptions.CommandNotExistException;
import org.javuntu.shell.Command;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, Command> registry = new LinkedHashMap<>();

    public CommandRegistry(Command[] commands) {
        init(commands);
    }

    private void init(Command[] commands) {
        for (Command command : commands) {
            register(command);
        }
    }

    private void register(Command command) {
        registry.put(command.name(), command);
    }

    public Command getCommand(String commandName) {
        Command command = registry.get(commandName);

        if (command == null) {
            throw new CommandNotExistException(commandName);
        }

        return command;
    }
}
