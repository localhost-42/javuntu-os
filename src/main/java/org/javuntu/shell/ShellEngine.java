package org.javuntu.shell;

import org.javuntu.exceptions.CommandNotExistException;
import org.javuntu.shell.services.*;

import java.util.ArrayList;
import java.util.List;

public class ShellEngine {
    private final CommandRegistry registry;
    private final CommandContext context;

    public ShellEngine() {
        List<Command> commands = CommandLoader.loadCommands(ShellConstants.PATH);
        registry = new CommandRegistry(commands.toArray(new Command[0]));

        context = new CommandContext();
    }

    public CommandResult execute(String line) {
        List<String> tokens = CommandParser.parse(line);

        if (tokens.isEmpty()) {
            return CommandResult.empty();
        }

        String commandName = tokens.get(0);
        List<String> args = new ArrayList<>(tokens.subList(1, tokens.size()));

        Command command = registry.getCommand(commandName);

        if (command != null) {
            return command.execute(context, String.valueOf(args));
        } else {
            throw new CommandNotExistException(commandName);
        }
    }

}
